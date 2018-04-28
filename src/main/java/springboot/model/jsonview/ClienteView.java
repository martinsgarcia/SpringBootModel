package springboot.model.jsonview;

import springboot.model.jsonview.page.JsonViewBase;

public class ClienteView {

	public interface Public extends JsonViewBase.Base {
	}

	public interface Vendas extends Public {
	}

	public interface Enderecos extends Public {
	}

}
