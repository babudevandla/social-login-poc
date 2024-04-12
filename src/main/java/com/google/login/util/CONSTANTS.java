package com.google.login.util;

import java.util.Arrays;
import java.util.List;

public class CONSTANTS
{

	public static final String FACEBOOK_APP_ID							= "315331678539858";
	public static final String NEST_USER_ID	= "nst_adm";
	//public static final String APP_REDIRECT_URL ="etogo://openApp";

	//public static final int	SILVER_EBOKS							   = 4000;
	//public static final int	SILVER_AUDIOBOKS						   = 1400;
	//public static final int	SILVER_MAGS								= 3600;
	//public static final int	SILVER_TITLES							  = 4;

	//public static final int	GOLD_EBOKS								 = 5000;
	//public static final int	GOLD_AUDIOBOKS							 = 2000;
	//public static final int	GOLD_MAGS								  = 3700;
	//public static final int	GOLD_TITLES								= 6;

	//public static final char[] LUCENE_DONT_LIKE						   = { '"', '\'', ':', '*', '(', ')', '-', '+', '{', '}', '[', ']' };
	/*public static final int	SORT_POPULARITY							= 1;
	public static final int	SORT_DATE								  = 2;
	public static final int	SORT_TITLE								 = 3;
	public static final int	SORT_AUTHOR								= 4;
	public static final int	SORT_NARATTOR							  = 5;
	public static final int	SORT_PRICE								 = 6;

	public static final int	SEARCH_ID								  = 0;
	public static final int	SEARCH_FORMAT_ID						   = 1;
	public static final int	SEARCH_CATEGORY_ID						 = 2;
	public static final int	SEARCH_AUTHOR_ID						   = 3;

	public static final int	SORT_ASEC								  = 1;
	public static final int	SORT_DESC								  = 2;

	public static final String AUTHOR_INSWED							  = "f�rfattare";
	public static final String NARATTOR_INSWED							= "uppl�sare";

	public static final int	ADV_BOOKS_TYPE_ALL						 = 0;
	public static final int	ADV_BOOKS_TYPE_EBOOKS					  = 1;
	public static final int	ADV_BOOKS_TYPE_AUDIOBOOKS				  = 2;
	public static final int	ADV_BOOKS_TYPE_PRESENTVCARD				= 3;

	public static final int	SYSPROP_SUBMENU_POPULAR_NEWAUDIOEBOOK	  = 10;
	public static final int	SYSPROP_SUBMENU_POPULAR_NEWEBOOK		   = 9;
	public static final int	SYSPROP_SUBMENU_NEW_AUDIO				  = 10;

	public static final int	ADV_BOOKS_DATUM_ALL						= 0;
	public static final int	ADV_BOOKS_DATUM_NEW						= 1;
	
	public static final int	ADV_BOOKS_DATUM_THREETOSIX				 = 2;
	
	public static final int	ADV_BOOKS_DATUM_SIXTOTWELEVE			   = 3;
	public static final int	ADV_BOOKS_DATUM_LASTYEAR				   = 4;

	public static final int	ADV_BOOKS_PRICE_ALL						= 0;
	public static final int	ADV_BOOKS_PRICE_ZEROTOFIFTY				= 1;
	public static final int	ADV_BOOKS_PRICE_HUNDREDTOONETWOFOUR		= 4;
	public static final int	ADV_BOOKS_PRICE_OVERONETWOFIVE			 = 5;

	public static final int	ADV_BOOKS_PRICE_FIFTYTOHUNDRED			 = 2;
	public static final int	ADV_BOOKS_PRICE_FROMHUNDRED				= 3;

	public static final String LANG_ALL								   = "all";
	public static final String LANG_SV									= "sv";
	public static final String LANG_EN									= "en";
	public static final String LANG_NW									= "no";
	public static final String LANG_DN									= "da";

	public static final String SESSION_ISMALMO							= "IS_MALMO";
*/
	public static final String SESSION_GIFTCARD						   = "PRESENT_KORT";

	public static final String LOGGEDIN_USER							  = "LOGGED_IN_USER";
	/*public static final String CONSUMED_POINT_MAP						 = "CONSUMED_POINT_MAP"; */
	public static final String SESSION_SHOPPING_CART_TRANS_KEY			= "trans_key";
	public static final String SESSION_SHOPPING_CART_INVALID_SESSION	  = "invalidsession";
	
	public static final String SESSION_PASSWORD_RESET_KEY				 = "PASSWORD_RESET_KEY";
	public static final String SESSION_CARD_EXPIRY_SOON				   = "CARD_EXPIRY_SOON";

	public static final String REQUEST_ORDER_REF						  = "e2goref";
	//public static final String LOGIN_PAGE								 = "mypages/register";
	public static final String URL_PARAMETER_NAME						 = "urlParameterName";

	//public static final String REDIRECT_TO_VARUKORG					   = "varu";
	//public static final String REDIRECT_TO_GIFT_VARUKORG				  = "los";

	//public final static int	POSTION_CONSTANT						   = 10000;

	// user profile constants

	public static final int	USER_PERSONAL_NO_LEN					   = 10;
	//public static final int USER_CELLPHONE_NO_LEN =  10;

	public static final int	USER_MOBILE_AND_CELL_MIN_LEN			   = 7;
	public static final int	USER_MOBILE_AND_CELL_MAX_LEN			   = 12;

	/*public static final int	USER_EMAIL_LEN							 = 200;
	public static final int	USER_FIRSTNAME_LEN						 = 45;
	public static final int	USER_LASTNAME_LEN						  = 45;
	public static final int	USER_ADDRESS1_LEN						  = 100;
	public static final int	USER_ADDRESS2_LEN						  = 100;*/
	public static final int	USER_PASSWORD_MAXLEN					   = 14;
	public static final int	USER_PASSWORD_MINLEN					   = 8;
	//public static final int USER_PASSWORD_VERIFY_LEN =  10;

/*	public static final int	MYPAGES_SORTBY_PURCHASEDATE				= 0;
	public static final int	MYPAGES_SORTBY_TITLE					   = 1;
	public static final int	MYPAGES_SORTBY_AUTHOR					  = 2;
	public static final int	MYPAGES_SORTBY_NARATTOR					= 3;
*/
	public static final int	MYPAGES_SORTBY_INVOICE					 = 4;
	public static final int	MYPAGES_SORTBY_PRICE					   = 5;

	public static final int	USER_POSTCODE_MINLEN					   = 4;
//	public static final int	USER_POSTCODE_MAXLEN					   = 5;
	public static final int	USER_CITY_MAXLEN						   = 45;
	public static final String COOKIENAME								 = "carthash";
	/*	public static final String SESSION_SHOPPINGCART_COUNT				 = "CART_COUNT";
*/
	public static final String SESSION_SHOPPINGCART_CAMPAGIN_CODE		 = "CAMPAGIN_CODE";

	public static final String TD_COOKIENAME							  = "TRADEDOUBLER";

	public static final String UPDATED_BY								 = "USER";

	public static final String MEMBERSHIP_SUBSCRIPTION					= "Prenumeration";
/*	public static final int	VAT_PROD_EBOOK							 = 1;
	public static final int	VAT_PROD_AUDIOBOOK						 = 2;
*/	public static final int	VAT_PROD_OTHER							 = 99;

	// menu status values
/*	public static final int	MENUSTAUS_HOME							 = 0;
	public static final int	MENUSTAUS_HELP							 = 4;
	public static final int	MENUSTAUS_MYPAGES						  = 7;
	public static final String MENUSTAUS_DETAILEDSEARCH				   = "6";
*/
	// not logged in submenu status values
/*	public static final int	NOTlOGGEDIN_SUBMENU_STATUS_REGISTER_GUIDE  = 0;
	public static final int	NOTlOGGEDIN_SUBMENU_STATUS_LOGGIN		  = 1;
	public static final int	NOTlOGGEDIN_SUBMENU_STATUS_REGISTER		= 2;
	public static final int	NOTlOGGEDIN_SUBMENU_STATUS_FORGOTPASSSWORD = 3;
*/
	// logged in submenu status values
/*	public static final int	lOGGEDIN_SUBMENU_STATUS_MYPAGES			= 0;
	public static final int	lOGGEDIN_SUBMENU_STATUS_LIBRARY			= 1;
	public static final int	lOGGEDIN_SUBMENU_STATUS_USERACCOUNT		= 2;
	public static final int	lOGGEDIN_SUBMENU_STATUS_SUBSCRIPTION	   = 3;
	public static final int	lOGGEDIN_SUBMENU_STATUS_CHANGEPASSWORD	 = 4;
	public static final int	lOGGEDIN_SUBMENU_STATUS_HISTORY			= 5;
	public static final int	lOGGEDIN_SUBMENU_STATUS_USERGUIDE		  = 6;
	public static final int	lOGGEDIN_SUBMENU_STATUS_FAVOURITES		 = 7;
	public static final int	lOGGEDIN_SUBMENU_STATUS_SALDO			  = 8;
	public static final int	lOGGEDIN_SUBMENU_STATUS_UPDATE_CREDIT_CARD = 9;
*/
	//public static final long GIFT_CARD_START_ID=100000;
	public static final int	PRODUCT_LIMIT_NORMAL_PAGES				 = 5;
	public static final int	PRODUCT_LIMIT_HOME_PAGE					= 10;
	public static final int	PRODUCT_LIMIT_DEVICE					   = 50;
	public static final int	GENERIC_TOP_PRODUCTS					   = 2;

	public static final int	API_RESULT_LIMIT						   = 50;

	public static final int	ALL_FORMAT								 = 0;

/*	public static final int	DUMMYSUBSCRIPTION_PRODUCTID				= 0;
	public static final int	SUBSCRIPTION_TYPE_ID					   = 4;
	public static final int	RESTRICT_TITLE_UPTO						= 16;
*/	
	public static final int	DEFAULT_PAGENUMBER						 = 1;
	public static final int	DEFAULT_PAGESIZE_WEB					   = 12;
	public static final int	DEFAULT_PAGESIZE_DEVICE					= 12;

	public static final int	QUANTITY								   = 1;

	public static final String DATEFORMAT								 = "yyyy/MM/dd HH:mm:ss";
	/*	public static final int	DEFAULT_SEQUENCE						   = 2;
	public static final int	DEFAULT_SORT_							  = 1;
	public static final int	PRICE_FOR_FREEPRODUCTS					 = 0;

	public static final int	LEFTMENU_GIFTCARD_ABOUT					= 1;
	public static final int	LEFTMENU_GIFTCARD_BUY					  = 2;
	public static final int	LEFTMENU_GIFTCARD_REDEEM				   = 3;

	public static final float  ZERO									   = 0.0f;
*/
	public static final String PAYNOVA_CURRENCY_KEY					   = "paynova.currency";
	public static final String PAYNOVA_LANG_KEY						   = "paynova.language";
	public static final String PAYMENT_FAILED_EXCEPTION				   = "payment.failed.exception";
	public static final String PAYMENT_DATA_TAMPERED_EXCEPTION			= "payment.data.tampered.exception";
	/*
	public static final Object PADDING_PROPERTY						   = "padding";

	public static final String LUCENE_AUTHOR_NAME						 = "authorname";
	public static final String LUCENE_NARATTOR_NAME					   = "narrator";
	public static final String LUCENE_POPULARITY_COUNT_FIELD_			 = "position";
	public static final String NEW_PRODUCT_WEIGHTAGE					  = "newprodweight";

	//public static final String CMS_GIFTCARD_TEMPLATE_SLUG = "giftcardtemplate";
	//public static final String CMS_REGISTER_TEMPLATE_SLUG = "registertemplate";
	//public static final String CMS_LOGIN_TEMPLATE_SLUG = "logintemplate";
	/*public static final String LUCENE_DISCOUNT_VALUE_FIELD = "dis_ebdiscount_value";
	public static final String LUCENE_POPULARITY_PRODUCTID_FIELD="popularity_productid";
	
	public static final String LUCENE_SALE_INDEX_FIELD="positiononsale";
	public static final String LUCENE_IS_BOOK_ON_SALE_FIELD="isbookonsale";
	
	public static final String LUCENE_AUTHOR_NAME_FIELD_SEARCH="author.name";
	public static String LUCENE_NARATTOR_NAME_FIELD_SEARCH ="narattor.name";
	public static final String LUCENE_AUTHOR_LAST_FIRST_NAME_FIELD_SEARCH="author.lastfirst";
	public static final String LUCENE_NARATTOR_LAST_FIRST_NAME_FIELD_SEARCH="narattor.lastfirst";*/
	//public static final String LUCENE_NARATTOR_NAME_FIELD_SEARCH="narattor.name";

	//db
	//public static final int SUBSCRIPTION_PRICE=125;

	/*public static  String PAYNOVA_NOTIFY_URL  = "http://87.237.215.54:30080/book2go/payment/notify";
	public static  String PAYNOVA_REDIRECT_OK_URL  = "http://87.237.215.54:30080/book2go/ok";
	public static  String PAYNOVA_REDIRECT_CANCEL_URL  = "http://87.237.215.54:30080/book2go/cancel";
	public static final int GIFTCARD_PRICE = 169;
	public static final int GIFTCARD_VALID_IN_MONTHS=12;  
	public static final int SUBSCRIPTION_VALID_IN_MONTHS=12;
	public static final String PAYNOVA_CUSTOMERID = "640799";
	public static final String PAYNOVA_SECRETKEY  = "J2P2ChF2vTTP77FD";*/

	public static final String GIFT_CARD_SUBJECT						  = "Giftcard(s) vocher Details";
	public static final String INVOICE_SUBJECT							= "Invoice Details - Book2go";
	public static final String REQUEST_CHANNEL							= "AJAX";

	/*public static final String SEARCH_FIELD_AUTHOR="author";
	public static final String SEARCH_FIELD_NARATTOR="narattor";*/

	/*public static String getAuthorInswed()
	{
		return AUTHOR_INSWED;
	}

	public static String getNarattorInswed()
	{
		return NARATTOR_INSWED;
	}*/

	// cms left menu

	/*public static final int	CMS_LEFTMENU_FAQ							= 1;
	public static final int	CMS_LEFTMENU_GUIDER						 = 2;
	public static final int	CMS_LEFTMENU_ORDERVILKOR					= 3;
	public static final int	CMS_LEFTMENU_CONTACT						= 4;*/

	//Class Bridge Constants

	/*public static final String HIB_LUCENE_FIELD_CATEGORY				   = "category";
	public static final String HIB_LUCENE_FIELD_AUTHOR_ASEC				= "author";
	public static final String HIB_LUCENE_FIELD_NARATTOR				   = "narrator";
	public static final String CLASSBRIDGE_ISBN							= "isbn";
	public static final String CONDITION_FOR_ACTIVE_PRODUCTS			   = "activeproduct";
	public static final String HIB_LUCENE_FIELD_RETAIL_PRICE			   = "retailprice";

	public static final String CATEGORY_FACET_NAME						 = "catfacet";
	public static final String FORMAT_FACET_NAME						   = "formatfacet";

	public static final String HIB_EDGE_TITLE							  = "edgeNGramtitle";
	public static final String HIB_NGRAM_TITLE							 = "nGramtitle";

	public static final String HIB_EDGE_AUTHOR							 = "edgeNGramauthor";
	public static final String HIB_NGRAM_AUTHOR							= "nGramauthor";

	public static final String HIB_EDGE_NARATTOR						   = "edgeNGramnarrator";
	public static final String HIB_NGRAM_NARATTOR						  = "nGramnarrator";
*/
	/*public static final String HIB_FIELD_POPULARITY 				= "popularity";
	public static final String HIB_FIELD_PRODUCTID 					= "productid";
	public static final String HIB_LUCENE_FIELD_CATEGORY 			= "category";
	public static final String HIB_LUCENE_FIELD_FORMATTYPE 			= "formattype";
	public static final String HIB_LUCENE_FIELD_PUBLISHED 			= "firstpublished";
	public static final String HIB_LUCENE_FIELD_LANG 				= "language";
	public static final String HIB_SEARCH_ORDER_DETAILS_PRODUCTID_	= "orderdetails_productid";
	public static final String HIB_SEARCH_ORDER_DETAILS_ORDERID_ 	= "orderdetails_orderid";
	public static final String HIB_SEARCH_ORDER_DETAILS_FORMATID	= "orderdetails_formatid";
	public static final String HIB_SEARCH_ORDER_TABLE_PREFIX_		= "odetails_";
	public static final String HIB_SEARCH_ORDER_TABLE_ORDERID_SUFFIX_= "orderid";
	public static final String HIB_LUCENE_FIELD_TEASER_LINK="teaserlink";
	
	
	public static final String HIB_LUCENE_FIELD_AUTHOR_ASEC="authorAsec";
	public static final String HIB_LUCENE_FIELD_AUTHOR_DESC="authorDesc";

	public static final String CLASSBRIDGE_MEMPRICE ="memprice";
	public static final String CLASSBRIDGE_RETAILPRICE ="retailprice";
	public static final String CLASSBRIDGE_SUBPRICE ="subprice";
	public static final String CLASSBRIDGE_TEXTEXACT_SEARCH ="textexactsearch";
	public static final String CLASSBRIDGE_ISBN ="isbn";
	public static final String CLASSBRIDGE_TITLE_TOKENZED ="title";

	
	public static final String HIB_SEARCH_ORDER_TABLE_CUSTOMERID_PREFIX_ 	= "customerid";
	*/

	//public static final String HIB_SEARCH_FIELD_ISBN						= CLASSBRIDGE_ISBN;
	//public static final String HIB_LUCENE_FIELD_TITLE_SEARCH_EXACT 			= CLASSBRIDGE_TEXTEXACT_SEARCH;

	/*public static final String FIELD_TITLE									= "title";
	public static final String FIELD_NARATTOR_FIRSTNAME    					= "narattor.firstname";
	public static final String FIELD_NARATTOR_LASTNAME 						= "narattor.lastname";
	public static final String FIELD_TITLE_SORT								= "title_forSort";
	
	public static final String FIELD_DISCRIPTION 							= "description";*/

	public static final int	PRODUCT_PRICE_CAT_AUTOMATTED_ASSOCIATION	= 0;
	public static final int	PRODUCT_PRICE_CAT_MANUAL_ASSOCIATION		= 1;
	public static final int	PRODUCT_PRICE_MANUAL_OVERRIDE			   = 2;
	public static final String PRODUCT_PRICE_MANUAL_CATEGORY			   = "MA";

	/*	public static final String CMS_LABEL_CUSTOMER_SERVICE				  = "kundtjanst";
	public static final String CMS_LABEL_TO_BOOK2GO						= "ombook2go-sv";*/
	public static final String SESSION_USER_ID							 = "CUSTOMER_ID";
	public static final String SESSION_GENERATED_HASHKEY				   = "HASH_KEY";

	public static final int	SYSPROP_SUBMENU_BOOK2GO					 = 1;
	public static final int	SYSPROP_SUBMENU_IMPORT					  = 2;
	public static final int	SYSPROP_SUBMENU_BANK						= 3;
	public static final int	SYSPROP_SUBMENU_CMS						 = 4;
	public static final int	SYSPROP_SUBMENU_OTHER					   = 5;
	public static final int	SYSPROP_SUBMENU_CATEGORY					= 6;
	public static final int	SYSPROP_SUBMENU_POPULAR_EBOOK			   = 7;
	public static final int	SYSPROP_SUBMENU_POPULAR_AUDIO			   = 8;
	public static final int	SYSPROP_SUBMENU_NEW_EBOOK				   = 9;
	public static final int	SYSPROP_SUBMENU_BANNERS					 = 10;
	public static final int	SYSPROP_SUBMENU_BANNERUPLOAD				= 11;
	public static final int	SYSPROP_SUBMENU_TEST_MAIL				   = 12;
	public static final int	SYSPROP_SUBMENU_CACHE					   = 13;

	public static final String AUDIO_BOOKS								 = "ljudbocker";
	public static final String E_BOOKS									 = "e-bocker";
	public static final String GIFTCARD_NAME							   = "Presentkort";
	//public static final String E_MAGAZINE								  = "e-magasin";

	/*public static final int FAILEDDETAILS_SUBMENU_IMAGE				    = 1;
	public static final int FAILEDDETAILS_SUBMENU_PRODUCT				= 2;
	public static final int FAILEDDETAILS_SUBMENU_AUDIO				    = 3;*/

	//Notifications

	/*public static final int WELCOME_EMAIL_NOTIFICATION_ID			= 1000;
	public static final int FORGOT_PASSWORD_EMAIL_NOTIFICATION_ID	= 1001;
	public static final int ORDER_EMAIL_NOTIFICATION_ID				= 1002;
	public static final int BOOKCHECK_EMAIL_NOTIFICATION_ID			= 1003;
	public static final int GIFTCARD_EMAIL_NOTIFICATION_ID			= 1004;
	public static final int ADMIN_EMAIL_NOTIFICATION_ID				= 1005;
	public static final int CUSTOMER_EMAIL_NOTIFICATION_ID			= 1006;*/

	//  Notification for Admin

	public static final String ELIB_SHOP_ORDER_FAILED_NOTIFICATION_SUBJECT = "Elib shop order failed Notification";
	//public static final String ADMIN_EMAIL_ID = "kumar.sudheer556@gmail.com";

	//COMMON
	//Used to store internal coding key and value 
	public static final String TEMPLATE_NAME							   = "TEMPLATE_NAME";
	public static final String EMAIL_SUBJECT							   = "EMAIL_SUBJECT";
	public static final String USER_EMAIL_ID							   = "USER_EMAIL_ID";
	public static final String USER_LIBRARY_LINK_URI					   = "USER_LIBRARY_LINK_URI";
	public static final String EMAIL_HEADER_IMG_URI						= "EMAIL_HEADER_IMG_URI";
	public static final String PRODUCT_IMG_URI							 = "PRODUCT_IMG_URI";
	public static final String MAGAZINE_IMG_URL_PART					   = "MAGAZINE_IMG_URL_PART";
	public static final String ADMIN_MSG								   = "ADMIN_MSG";
	public static final String CUSTOMER_EMAIL_ID						   = "CUSTOMER_EMAIL_ID";
	public static final String CUSTOMER_MSG								= "CUSTOMER_MSG";
	public static final String EMAIL_TEMPLATE							  = "EMAIL_TEMPLATE";
	public static final String MEMBERSHIP_ACTIVE_DATE					  = "MEMBERSHIP_ACTIVE_DATE";
	public static final String PRESENTKORT_PURCHASE_AMOUNT				 = "PRESENTKORT_PURCHASE_AMOUNT";
	// Used to store the Template fields
	public static final String FIRST_NAME								  = "FIRST_NAME";
	public static final String USER_LIBRARY_LINK						   = "USER_LIBRARY_LINK";
	public static final String BOOK2GO_URL								 = "BOOK2GO_URL";
	public static final String BOOK2GO_CONTEXT_URL						 = "BOOK2GO_CONTEXT_URL";
	public static final String POPULAR_PRODUCTS							= "POPULAR_PRODUCTS";
	public static final String EMAIL_HEADER_IMG							= "EMAIL_HEADER_IMG";
	public static final String PRODUCT_IMG_PATH							= "PRODUCT_IMG_PATH";
	public static final String MAGAZINE_IMG_PATH						   = "MAGAZINE_IMG_PATH";

	public static final String NUMBER_UTIL								 = "NUMBER_UTIL";
	public static final String GIFT_CARD_IN_ORDER						  = "GIFT_CARD_IN_ORDER";
	public static final String LOCALE									  = "LOCALE";
	public static final String IMAGE_RESIZE_URL							= "IMAGE_RESIZE_URL";
	//TELL YOUR FRIEND 
	public static final String MESSAGE_BEAN								= "MESSAGE_BEAN";
	//SYSTEM ADMIN EXCEPTION BEAN
	public static final String EXCEPTION_BEAN							  = "EXCEPTION_BEAN";
	public static final String ERROR_ID									= "ERROR_ID";
	//FOGOT PASSWORD EMAIL
	public static final String FORGOT_PASSWORD_URL						 = "FORGOT_PASSWORD_URL";

	//ORDER email
	public static final String ORDER_DATA								  = "ORDER_DATA";

	//BOOKCHECK EMAIL
	public static final String USER_LOGIN_LINK							 = "USER_LOGIN_LINK";
	public static final String USER_LOGIN_LINK_URI						 = "USER_LOGIN_LINK_URI";

	public static final String USER_SUBSCRIPTION_POINT					 = "USER_SUBSCRIPTION_POINT";
	public static final String GIFTCARD_TEMPLATE_1_PDF_URI				 = "GIFTCARD_TEMPLATE_1_PDF_URI";
	public static final String GIFTCARD_TEMPLATE_3_PDF_URI				 = "GIFTCARD_TEMPLATE_3_PDF_URI";
	public static final String GIFTCARD_TEMPLATE_6_PDF_URI				 = "GIFTCARD_TEMPLATE_6_PDF_URI";
	public static final String GIFTCARD_TEMPLATE_X_PDF_URI				 = "GIFTCARD_TEMPLATE_X_PDF_URI";
	public static final String GIFTCARD_ATTACHMENT_FILE_NAME			   = "GIFTCARD_ATTACHMENT_FILE_NAME";
	public static final String GIFTCARD_ATTACHMENT_FILE_PATH			   = "GIFTCARD_ATTACHMENT_FILE_PATH";
	public static final String GIFTCARD_FOLDER_NAME						= "GIFTCARD_FOLDER_NAME";
	public static final String SUBSCRIPTION_MONTHS						 = "SUBSCRIPTION_MONTHS";

	public static final String MEMBERSHIP_NAME							 = "MEMBERSHIP_NAME";
	public static final String ROLLBACK_CUSTOMER_PURCHSAE_LIST			 = "ROLLBACK_CUSTOMER_PURCHSAE_LIST";
	public static final String FAILED_CUSTOMER_PURCHSAE_PRODUCT			= "FAILED_CUSTOMER_PURCHSAE_PRODUCT";

	public static final String MAIL_SUBJECT_ELIB_TRANSACATION_FAILED	   = "Elib Shop Order Failed";

	public static final String SHORT_DATE_FORMAT						   = "yyyy-MM-dd";

	public static final float  SUBSCRIPTION_RUN_DAYS					   = 30;
	public static final float  TRAIL_SUBSCRIPTION_RUN_DAYS				 = 7;
	public static final float  VOUCHER_SUBSCRIPTION_RUN_DAYS			   = 90;

	public static final String BOOKCHEQUE_SESSION_DATA					 = "BOOKCHEQUE_SESSION_DATA";
	public static final String BOOKCHEQUE_SESSION_PRODUCTID				= "BOOKCHEQUE_SESSION_PRODUCTID";
	public static final int	OFFLINE_READER_MAX_BOOK_LIMIT			   = 3;
	public static final int	DEFAULT_WINDOWSIZE						  = 12;
	public static final String REFERRER_TOKEN							  = "REFERRER_TOKEN";

	public static final String LIBRARY_SYNC_DEFAULT_DATE				   = "01-01-2014 00:00:00 +0200";

	/* Payex vat constants .Please contact you superior before changing the value */
	public static final int	VAT_FOR_PURCHASE							= 2500;
	public static final int	VAT_FOR_AGREEMENT						   = 0;
	/* Payex vat constants .Please contact you superior before changing the value */

	/*
	 *  MONGODB CONSTANTS 
	 */

	public static final String EMAIL_TEMPLATE_BANNER_URL				   = "EMAIL_TEMPLATE_BANNER_URL";

	public static final String MONGO_E2GO_SUBSCRIPTION_CHANGE_LOG			   = "subscription_change_log";
	public static final String MONGO_E2GO_SUBSCRIPTION_DAILY_LOG				 = "subscription_daily_log";
	public static final String MONGO_E2GO_LIBRARY_READ_PERCENTAGE_LOG		   = "app_library_read_percentage_log";
	//public static final String MONGO_E2GO_DB_NAME ="e2go";
	
	
	public static final String MONGO_NEXT_MEMBERSHIP_CHANGE_LOG  = "nx_membership_change_log";
	public static final String MONGO_NEXT_MEMBERSHIP_DAILY_LOG  = "nx_membership_daily_log";
	public static final String MONGO_NEXT_READNING_BEHAVIOUR_LOG = "nx_reading_behaviour_log";
	public static final String MONGO_NEXT_LIBRARY_BEHAVIOUR_LOG  = "nx_library_behaviour_log";
	public static final String MONGO_NEXT_CUSTOMER_SEARCH_BEHAVIOUR_LOG = "nx_customer_search_behaviour_log";
	public static final String MONGO_NEXTB_LIBRARY_BEHAVIOUR_LOG  = "nextory_price_behaviour_log";
	public static final String MONGO_LAST_MEMBERSHIP_LOG  = "nx_last_membership_log";
	public static final String MONGO_NEXT_DAILY_JOBS_LOG = "nx_customer_daily_jobs_log";
	//public static final String MONGO_NEXT_SUBSCRIPTION_UP_OR_DOWN_GRADE_LOG = "nx_subscription_up_or_down_grade_log";
	public static final String MONGO_NEXT_SUBSCRIPTION_MASTER_LOG = "nx_subscription_master_log";
	public static final String MONGO_NEXT_PRODUCT_ALLOWED_FOR_LOG = "nx_product_allowed_for_log";
	public static final String MONGO_NEXT_LIBRARY_BOOK_BEHAVIOUR_LOG  = "nx_library_book_behaviour_log";
	public static final String MONGO_NEXT_BOOK_ACTIVATE_DEACTIVATE_LOG = "nx_book_activation_deactivation_log";
	//NEX-730
	public static final String MONGO_NEXT_APP_DEVICE_LOG = "nx_app_device_log";
	public static final String MONGO_NEXT_MEMBERSHIP_CHANGE_REDUCED_LOG = "nx_last_membership_log";
	

	public static final String TOTAL_BOOKCOUNT							 = "TOTAL_BOOKCOUNT";
	public static final String E_BOOKCOUNT 								="E_BOOKCOUNT";
	public static final String AUDIO_BOOKCOUNT 							="AUDIO_BOOKCOUNT";
	
	public static final String RECRUIT_FRIEND_FREE_DAYS 				="RECRUIT_FRIEND_FREE_DAYS";
	public static final String PASSWORD="password";
	public static final String IGNORE_ACTUAL_PASSWORD="PWDIGNORE";
	public static final String USER_PASSWORD="76C3123DBEDEC1E13F920DB346B9C5BC";

	public static final String MONGO_REPORT_LIBRARY_PUBLISHER_LOG = "report_library_publisher_log";
	public static final String NLOB_PRICE_BEHAVIOUR_LOG = "nextory_price_behaviour_log";
	public static final String PASSWORD_PATTERN="^[a-zA-Z0-9_@#$%-]*$";
	public static final String FACEBOOK_LINK				 = "FACEBOOK_LINK";
	public static final String TWITTER_LINK				 = "TWITTER_LINK";
	public static final String INSTAGRAM_LINK				 = "INSTAGRAM_LINK";
	public static final String SINGLE_TOP_LIST_SLUG="topplista-bocker";
	public static final String TOP_EBOOK_SLUG="topplista-e-bocker";
	public static final String TOP_ABOOK_SLUG="topplista-ljudbocker";
	
	public static final String ADMIN_OVERRIDEN_LOG = "isbn_thema_log";
	
	public static final String PRODUCT = "product";
	public static String COUNTRY_CODE_FI="FI";
	public static final String PRODUCT_TRACKER="productTracker";
	public static final String MATRIX_TYPE ="MATRIX_TYPE";
	public static final String MATRIX_TYPE_ADVANCED ="advanced";
	public static final String KAFKA_THEMA_UPDATE_TOPIC ="nestadminrequest";
	public static final String NEST_ADMIN_REQUEST ="nestadminrequest";
	public static final String KAFKA_CAMEL_API_REFRESH ="camelapi";
	public static final String KAFKA_NEXTORY_API_REFRESH ="nextoryapi";
	public static final String SOURCE_PUBLIT ="PUBLIT";
	public static final String ALTERNATIVE_SOURCE_MER ="MER";
	public static final String PRODUCT_STATUS_CHANGED = "PRODUCT_STATUS_CHANGED";
	public static final String ADD_CATEGORYLIST = "ADD_CATEGORYLIST";
	public static final String UPDATE_PRODUCT_VARIANT = "UPDATE_PRODUCT_VARIANT";
	public static final String ADMIN_RELATION_MODIFICATION = "ADMIN_RELATION_MODIFICATION";
	public static String ADMIN_DATA_REFRESH ="ADMIN_DATA_REFRESH";
	public static String ISBN_THEMA_UPDATE="ISBN_THEMA_UPDATE";
	public static String PUBLISHER_META_REPROCESS="PUBLISHER_META_REPROCESS";
	public static String ALL="ALL";
	public static String COUNTRY_CODE_SWEDEN="SE";
	public static final String QR_PREFIX = "https://chart.googleapis.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=";
	public static final String APP_NAME = "nestadmin";
	public static final String QR_OTP_AUTH_RUL="otpauth://totp/%s:%s?secret=%s&issuer=%s";
	public static final String PRE_AUTH_="PRE_AUTH_";
	
	public static final String SOURCE_FINDAWAY	= "FINDAWAY";
	public static final String DEFAULT_MARKET_CODE="SE";
	public static final String KAFKA_ADMIN_ACTTIONS_URL="KAFKA_ADMIN_ACTTIONS_URL";
	public static final String MONGO_NEST_VER2="nest_ver2";
	public static final String MONGO_ADMIN_OVERRIDEN_META="admin_overridden_meta";
	public static final String ISBN="isbn";
	public static final String MARKET_DETAILS="market_details";
	public static final String ALLOWED_FOR="allowedfor";
	public static final String MONGO_COLL_PRICELOG="pricelog";
	public static final String MONGO_COLL_PRICEINFO="priceinfo";
	public static final String MONGO_COLL_PRODUCT_CATEGORY="product_category";
	public static final String MONGO_DB_NEXTORY="nextory";
	public static final String FRESCANO_SETTINGS_PROJECT="plasma-set-92411";
	public static final String FRESCANO_SETTINGS_BUCKET="nest-cover-images";
	
	public static final String OVERRIDEN_ITEMS="OVERRIDEN_ITEMS";
	public static final String ML_ITEMS="ML_ITEMS";
	public static final String LANG_SV= "sv";
	public static final String ML_ITEMS_MONGO= "mlItems";
	public static final String RAW_ITEMS_MONGO= "rawItems";
	public static final String OVERRIDEN_THEMA_DESC_MAP ="OVERRIDEN_THEMA_DESC_MAP";
	public static final String ML_THEMA_DESC_MAP ="ML_THEMA_DESC_MAP";
	public static final String TTTL_UPCOMING="tttl_Upcoming";
	public static final String DELETE_CONSTANT="DELETE";
	public static final String STATUS_CONSTANT="status";
	public static final String UPCOMING_TOPLIST_TITLE="Upcoming";
	
	public static boolean mediaDownloadable(String src){
	  List<String>  allowedSrc = Arrays.asList(CONSTANTS.SOURCE_PUBLIT);
	  List<String>  allowedASrc = Arrays.asList(CONSTANTS.ALTERNATIVE_SOURCE_MER);
	  return ( allowedSrc.contains( src ) || allowedASrc.contains( src )) ? true:false;
	}
	
}
