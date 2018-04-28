package springboot.model.jsonview.page;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonView;

@SuppressWarnings("all")
public class JsonPage<T> extends PageImpl<T> {

	public JsonPage(final List<T> content, final Pageable pageable, final long total) {
		super(content, pageable, total);
	}

	public JsonPage(final List<T> content) {
		super(content);
	}

	public JsonPage(final Page<T> page, final Pageable pageable) {
		super(page.getContent(), pageable, page.getTotalElements());
	}

	@JsonView(JsonViewBase.Base.class)
	public int getTotalPages() {
		return super.getTotalPages();
	}

	@JsonView(JsonViewBase.Base.class)
	public long getTotalElements() {
		return super.getTotalElements();
	}

	@JsonView(JsonViewBase.Base.class)
	public boolean hasNext() {
		return super.hasNext();
	}

	@JsonView(JsonViewBase.Base.class)
	public boolean isLast() {
		return super.isLast();
	}

	@JsonView(JsonViewBase.Base.class)
	public boolean hasContent() {
		return super.hasContent();
	}

	@JsonView(JsonViewBase.Base.class)
	public List<T> getContent() {
		return super.getContent();
	}
}
