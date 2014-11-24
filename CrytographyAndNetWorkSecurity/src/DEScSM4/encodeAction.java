package DEScSM4;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class encodeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String simple;
	private String key;
	private char[] secret;

	public String getSimple() {
		return simple;
	}

	public char[] getSecret() {
		return secret;
	}

	public void setSecret(char[] secret) {
		this.secret = secret;
	}

	public void setSimple(String simple) {
		this.simple = simple;
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
		Code code = new Code(simple,key);
        ActionContext.getContext().getSession().put("simple", getSimple());
        ActionContext.getContext().getSession().put("key", getKey());
        secret = code.enCode(true);
        ActionContext.getContext().getSession().put("secret", getSecret());
		return SUCCESS;
	}


}
