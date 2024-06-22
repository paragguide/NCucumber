package externalxpath;

public class AmazonXpath 
{
	 // login..
	public static final String signin = "//*[text() = 'Hello, sign in']";
   public static final String uid = "//*[@id=\"ap_email\"]";
   public static final String ctnbtn = "//*[@id=\"continue\"]";
   public static final String err1 = "//*[@id=\"auth-error-message-box\"]/div/h4";
   public static final String pwd = "//*[@id=\"ap_password\"]";
   public static final String submit = "//*[@id=\"signInSubmit\"]";
   public static final String err2 = "//*[@id=\"auth-error-message-box\"]/div/h4";
   
    // product search
   public static final String productsearchbox = "//*[@id=\"twotabsearchtextbox\"]";
   public static final String productresults = "//*[@class = 'a-size-base-plus a-color-base a-text-normal']";
	
   // forget pwd 
   public static final String help = "//*[@id=\"authportal-main-section\"]/div[2]/div[2]/div[1]/form/div/div/div/div[3]/div/a/span";
   public static final String forgetpwdlink = "//*[@id=\"auth-fpp-link-bottom\"]";
   public static final String forgettxtbox = "//*[@id=\"ap_email\"]";
}
