package com.google.login.util;

public class URLConstants {
	
	//Admin urls
	public static final String PRODUCT_SEARCH = "/admin/product/search";
	public static final String PRODUCT_SEARCH_SUBMIT = "/admin/product/searchsubmit";
	public static final String PRODUCT_EDIT= "/admin/product/productedit";
	public static final String PRODUCT_FINAL_PRICE= "/admin/product/productfinalprice";
	public static final String PRODUCT_ACTIVATE= "/admin/product/activate";
	public static final String PRODUCT_DEACTIVATE= "/admin/product/deactivate";
	public static final String PRODUCT_ALLOWEDFOR_UPDATE= "admin/product/allowedfor/update";
	public static final String PRODUCT_ALLOWEDFOR_RESET= "admin/product/allowedfor/reset";

	
	public static final String ORDER_SEARCH = "/admin/order/search";
	public static final String ORDER_SEARCH_SUBMIT = "/admin/order/searchsubmit";
	public static final String UPDATE_FORMATLINK = "/admin/product/updateformat";
	public static final String PUBLISHER_SETTINGS_CREATE = "/admin/publisher/settings/create";
	public static final String PUBLISHER_CREATE = "/admin/publisher/create";
	public static final String PUBLISHER_SETTINGS_EDIT = "/admin/publisher/settings/edit";
	public static final String PUBLISHER_EDIT = "/admin/publisher/edit";
	public static final String PUBLISHER_DETAILS_BY_NAME = "/admin/publisher/details";
	public static final String PUBLISHER_SETTINGS_LIST = "/admin/publisher/settings/";
	public static final String PUBLISHER_LIST = "/admin/publisher/list/";
	public static final String PUBLISHER_EXPORT_LIST = "/admin/publisher/publisherlist-export";
	public static final String PUBLISHER_SETTINGS_PROCESS_FILENAME_WITH_REGEX = "/admin/publisher/settings/processfilenamewithregex";
	public static final String PUBLISHER_SETTINGS_PROCESS_FILENAME_WITH_REGEX_SUBMIT = "/admin/publisher/settings/processwithregexp";
	public static final String PUBLISHER_SETTINGS_PARKED_LOGS = "/admin/ajax/publisher/settings/parkedlogs";
	public static final String PUBLISHER_SETTINGS_FAILED_LOGS = "/admin/ajax/publisher/settings/failedlogs";
	public static final String PUBLISHER_SETTINGS_FAILED_LOGS_MASTER = "/admin/publisher/settings/failedlogsmaster";
	public static final String PUBLISHER_SETTINGS_FAILED_LOGS_MASTER_FOR_REGEXP_FAILED = "/admin/publisher/settings/regexpfailedlogs";
	public static final String PUBLISHER_SETTINGS_UPDATE_ISBN = "/admin/publisher/settings/updateisbn";
	public static final String PUBLISHER_SETTINGS_UPDATE_STATUS = "/admin/publisher/settings/updatestatus";
	public static final String PUBLISHER_UPDATE_STATUS = "/admin/publisher/updatestatus";
	public static final String PUBLISHER_SETTINGS = "/admin/publisher/settings/list";
	public static final String PUBLISHER_FORMAT = "/admin/publisher/settings/format";
	public static final String PUBLISHER_FORMAT_EIDT = "/admin/publisher/settings/format/edit";
	public static final String PUBLISHER__ASSOCIATION = "/admin/publisher/association";
	public static final String UPDATE_FORMAT_MISMATCH_ISBN = "/admin/format/mismatch/updateisbn";
	public static final String UPDATE_REGEXP_FAILED_FILENAME = "/admin/publisher/settings/updatefilename";
	public static final String UPDATE_REGEXP_FAILED_FILENAME_SUBMIT = "/admin/publisher/settings/regexpfailedupdatefilename";
	public static final String PRODUCT_FILE_LINK_EDIT = "/admin/product/productFileLinkEdit";
	public static final String PRODUCT_FILE_LINK_DOWNLOAD = "/admin/product/fileDownload";
	public static final String PRODUCT_LIST_FORMATS = "/product/listfiles";
	public static final String MOVE_FTP_FILES= "/admin/move/ftpfiles";
	public static final String APPROVECONTRACT = "/admin/publisher/approvecontract";

	
	//API urls
	public static final String DOWNLOAD_PRODUCT= "/api/ver1/product/download";
	public static final String DOWNLOAD_PRODUCT_V2= "/api/ver2/product/download";
	public static final String List_PRODUCT= "/api/ver1/product/listfiles";
	public static final String CREATE_ORDER= "/api/ver1/order/createorder";
	public static final String CREATE_ORDER_ver2= "/api/ver2/order/createorder";
	public static final String STORE_PRODUCT_DETAILS= "/api/ver1/store/productdetails";
	public static final String LINK_FILES= "/api/ver1/store/linkfiles";
	public static final String SYNC_PRODUCT_STATUS= "/api/ver1/sync/productstatus";
	public static final String PUBLISHER_AVAILABILITY = "/admin/publisheravailability";
	public static final String DOWNLOAD_PUBLISHER_BOOKS = "/api/ver1/publisher/download";
	public static final String GET_PRODUCT_DATA = "/admin/product/getproductdata";
	
	public static final String MANUAL_TRIGGERS = "/admin/triggers";
	public static final String RUN_TRIGGER = "/admin/trigger";
	public static final String DB_NAME = "test";
	
	public static final String TITLE_STATISTICS = "/admin/title/statistics";
	public static final String GET_ELIB_PRODUCT = "/admin/elib/getproduct/{productId}";
	public static final String SUB_STATISTICS = "/admin/subscription-wise/statistics";
	
	public static final String PRODUCT_DEFERRED_ACTIVATE= "/admin/product/deferred/activate";
	
	//below 5 stmts added by omprakash
	public static final String GET_PUBLIT_PRODUCT ="/admin/publit/getproduct/{isbn}";
	public static final String GET_EXCEL_PRODUCT_META ="/admin/excel/getproduct/{isbn}";
	public static final String GET_ONIX_PRODUCT_META ="/admin/onix/getproduct/{isbn}";
	//public static final String DOWNLOAD_PRODUCT_IMAGE ="/admin/product/allowedfor/productImage";
	public static final String DOWNLOAD_COVER_IMAGE = "/admin/product/downloadcoverimage";
	public static final String GET_SERIES_LIST = "/admin/product/getserieslist";
	public static final String NAVIGATE_TO_PRODUCT_SEARCH_FROM_SERIES = "/admin/product/navigatetoproductaearch";
	public static final String EDIT_SERIES = "/admin/series/edit-series";
	
	
	//ADDED FOR NEST 602
		public static final String SHOW_ALL_ACTIVE_STATISTICS = "/admin/show_all_active_publishers/statistics";
		public static final String NOT_CONTRACTED_PUBLISHERS = "/admin/not_contracted_publishers/statistics";
		public static final String PUBLISHER_LIST_AJAX = "/admin/publisherList";
		public static final String SERIESNAME_LIST_AJAX="/admin/seriesNameList";
		public static final String ADMIN_OVERRIDEN_HISTORY = "/admin/product/admin_overriden_history";
		public static final String NOT_CONTRACTED_PUBLISHERS_DETAILS = "/admin/not_contracted_publishers/statistics/details";
		public static final String PUBLISHERGROUP_LIST_AJAX = "/admin/publishergroupList";
		
		public static final String PROMOTE_DEPROMOTE="/admin/promotedepromote";
	public static final String VIEW_META ="/admin/view_meta";
	public static final String VIEW_TWO_FACTOR_ATHENTICATION_PAGE="/preAuth/viewtwofapage";
	public static final String VIRIFY_TOTP="/preAuth/verifytotp";
	public static final String AUTH_SUCCESS_RUL="/preAuth/2fa";
	public static final String ENABLE_TWO_FACTOR_AUTHENTICATION="/preAuth/enabletwofactorauthentication";
	public static final String GET_OTP="/prelogin/getotp";
	public static final String ACCESS_DENIED="/acessdenied";
	public static final String VIEW_META_LIST ="/admin/view_meta_list/{isbn}";
	public static final String VIEW_META_V2 ="/admin/view_metaV2";
}
