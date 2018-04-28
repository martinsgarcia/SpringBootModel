'use strict';

var gulp = require('gulp')
    , clean = require('gulp-clean')
    , gulpSequence = require('gulp-sequence')
    , RevAll = require('gulp-rev-all')
	, uglify = require('gulp-uglify')
    , minifyCSS = require('gulp-minify-css')
    , postcss      = require('gulp-postcss')
    , sourcemaps   = require('gulp-sourcemaps')
    , autoprefixer = require('autoprefixer')
	, imagemin = require('gulp-imagemin');	

gulp.task('clean',function(){
  return gulp.src('dist')
    .pipe(clean());
});

gulp.task('copy', function () {
  return gulp
    .src(['src/**'])
    .pipe(gulp.dest('dist'));
});

gulp.task('rev-all', function () {
  return gulp
    .src(['dist/**', '!dist/libs/**'])
    .pipe(RevAll.revision({ dontRenameFile: [/^\/favicon.ico$/g, '.html', '.png', '.jpg', '.jpeg', '.gif'], dontUpdateReference: ['.html', '.htm']}))
    .pipe(gulp.dest('dist'))  
    .pipe(RevAll.manifestFile())
    .pipe(gulp.dest('dist')); 

});

gulp.task('image', () =>
    gulp.src(['dist/**/*.*', '!dist/libs/**'])
        .pipe(imagemin())
        .pipe(gulp.dest('dist'))
);

gulp.task('js', function () {
  return gulp
    .src(['dist/**/*.js', '!dist/libs/**'])
    .pipe(uglify())
    .pipe(gulp.dest('dist')); 
});

gulp.task('css', function() {
  gulp.src(['dist/**/*.css', '!dist/libs/**'])
    .pipe(minifyCSS())
	.pipe(sourcemaps.init())
    .pipe(postcss([ autoprefixer({ browsers: [
                                                  "Android 2.3",
                                                  "Android >= 4",
                                                  "Chrome >= 20",
                                                  "Firefox >= 24",
                                                  "Explorer >= 8",
                                                  "iOS >= 6",
                                                  "Opera >= 12",
                                                  "Safari >= 6"
                                                ] }) ]))
    .pipe(sourcemaps.write('.'))
    .pipe(gulp.dest('dist'));
});

gulp.task('copy-resources-static', function () {
  return gulp
    .src(['dist/**'])
    .pipe(gulp.dest('../resources/static/pages'));
});

gulp.task("build-prod", function (event) {
  gulpSequence('clean', 'copy', 'rev-all', 'js', 'css', 'image', 'copy-resources-static')(function (err) {
    if (err) console.log(err)
  })
});