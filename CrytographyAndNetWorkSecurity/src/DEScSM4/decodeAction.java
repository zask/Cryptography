package DEScSM4;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class decodeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String secret;
	private String key;
	private char[] simple;

	public char[] getSimple() {
		return simple;
	}

	public void setSimple(char[] simple) {
		this.simple = simple;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Code c = new Code(getSecret(),getKey());
        ActionContext.getContext().getSession().put("secret", getSecret());
        ActionContext.getContext().getSession().put("key", getKey());
        simple = c.enCode(false);
        ActionContext.getContext().getSession().put("simple", getSimple());
		return SUCCESS;
	}


}
