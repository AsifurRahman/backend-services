package com.asif.backend.common.constant;

import org.springframework.util.ResourceUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApplicationConstant {
    /**
     * change status
     */
    public static final String STATUS_CHANGED =  "Status Changed Successfully !";
    /**
     * trace id constant
     */
    public static final String TRACE_ID = "traceId";
    /**
     * errorCode json file name
     */
    public static final String ERROR_CODE_JSON_FILE = "error/error_code.json";


    public static final String AUTHORIZATION_TYPE_BEARER = "Bearer";

    /**
     * Default page size while paginated query
     */
    public static final int DEFAULT_SIZE = 10;
    public static final String DEFAULT_SORT = "id";
    /**
     * Minimum character is 8, only alphabet & number. It also allows symbol. and within character & number & symbol, at least use 2 item mandatory.
     */
    public static final String VALID_PASSWORD_REGEX = "^((((?=.*?[A-Z])|(?=.*?[a-z]))(?=.*?[0-9]))" +
            "|((?=.*?[0-9])(?=.*?[!#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]))|" +
            "((?=.*?[!#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~])((?=.*?[A-Z])|(?=.*?[a-z])))).{8,256}$";
    /**
     * Email validation regex
     */
    public static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String DATE_TYPE_VALIDATION_REGEX = "[-/.]";
    public static final String REPLACE_DATE_TYPE_VALIDATION_REGEX = "[-/]*";
    public static final String ALL_INTEGER_VALIDATION_REGEX = "[0-9]+";
    public static final String SHELF_LIFE_VALIDATION_REGEX = "[.\\/ \\-,]";
    /**
     * Default page number.
     */
    public static final String DEFAULT_PAGE_NUMBER = "1";
    /**
     * Default page size.
     */
    public static final String DEFAULT_PAGE_SIZE = "20";
    /**
     * deletion message
     */
    public static final String DELETED_SUCCESSFULLY = "Deleted Successfully";
    public static final String EMPTY_STRING = "";
    public static final String ENTITY_NAME = "name";
    public static final String ENTITY_EMAIL = "email";
    public static final Long ANONYMOUS_USER = -1L;
    public static final String SUBMODULE_ITEM_ID = "subModuleItemId";
    public static final String ID = "id";
    public static final String MESSAGE_SEPARATOR = "###";
    public static final String RACK_ROW = "Rack Row";
    public static final String RACK = "Rack";
    public static final String WORKFLOW_TYPE = "workflowType";
    public static final String ROOM = "Room";
    public static final String OFFICE = "Office";
    public static final String STATIC_ERP_ID = "1";
    public static final String DESIGNATION = "Designation";
    public static final String DEPARTMENT = "Department";
    public static final String SECTION = "Section";
    public static final String USER = "User";
    public static final String EMPLOYEE = "Employee";
    public static final String LOGIN = "Login";
    public static final String AUTH_CODE = "authCodeNo";
    public static final String WORKFLOW_ACTION = "workFlowAction";
    public static final String CONFIG_SUBMODULE_ITEM = "configSubmoduleItem";
    public static final String CARD_NUMBER = "USBA/ENGG/STORE/";

    public static final String AC_TYPE_ATR_72_600 = "ATR 72-600";

    public static final String DATE_TYPE = "dateType";

    public static final String DASH = "-";
    public static final String DOT = ".";
    public static final String SLASH = "/";
    public static final String REVISED = "R";
    public static final char SLASH_CHAR = '/';
    public static final String FOUR_DIGIT_FORMAT = "%04d";

    public static final String ITEM_PART = "part";
    public static final String RFQ_ID = "quoteRequestId";
    public static final String CS_NO = "comparativeStatementNo";
    public static final String IS_REJECTED = "isRejected";
    public static final String APPROVED = "APPROVED";
    public static final String CS_WORKFLOW_TYPE = "workflowType";
    public static final String SERIAL_NUMBER = "serialNumber";
    public static final String SERIAL_TABLE = "serial";
    public static final String PART_AVAILABILITY = "storePartAvailability";
    public static final String PART_AVAILABILITY_ID = "storePartAvailabilityId";
    public static final String MODULE = "config_module";
    public static final String SUB_MODULE = "config_sub_module";
    public static final String SUB_MODULE_ITEM = "config_sub_module_items";
    public static final String PART_ORDER_ID ="partOrderId" ;
    public static final String RFQ = "quote request";
    public static final String EMAIL_TEMPLATE = "email-template.ftl";
    public static final String NEW_PASSWORD_TEMPLATE = "new-password.ftl";
    public static final String WORK_ORDER_NO_INITIAL = "USBA/STR";
    public static final String UNDER_SCORE = "_";
    public static final String SERVICEABLE = "SVC";
    public static final String UNSERVICEABLE = " U/S";
    public static final int REMARK_MAX_LENGTH = 5;
    public static final String SPACE_REGEX = "\\s+";
    public static final String PART_INVOICE = "partsInvoice";
    public static final Double DEFAULT_PRICE = 0.0;
    public static final Long QUALITY_MANUFACTURER = 50120L;
    public static final Long QUALITY_SUPPLIER = 50124L;
    public static final Long QUALITY_SHIPMENT_PROVIDER = 50122L;
    public static final String VENDOR_NAME = "name";
    public static final String VENDOR_TYPE_OPERATOR = "vendorType";
    public static final Long INSPECTION_CHECKLIST_QUALITY = 50126L ;

    public static final String SERIAL_HEAD = "[S/N:]";
    public static final String TRACKER_NO = "trackerNo";
    public static final String PURCHASE = "PO";
    public static final String LOAN = "LO";
    public static final String REPAIR = "RO";
    public static final String ORDER_NO_PREFIX="USBA";
    public static final String DEPARTMENT_ID = "departmentId";
    public static final String SECTION_ID = "sectionId";
    public static final String DESIGNATION_ID = "designationId";
    public static final String INVISIBLE = "INVISIBLE ";
    public static final String INVISIBLE_REMARK = "INVISIBLE STORE DEMAND ITEM";
    public static final String MODEL = "model";

    public static final String COULD_NOT_PARSE_DATA = "Could not parse data !";
    public static final String STORE_LIFE_TYPE_FILE = "store_life_types.json";
    public static final String NOT_APPLICABLE_KEY = "NA";
    public static final String RETURN_PART_DETAILS = "returnPartsDetail";
    public static final String INPUT_TYPE = "inputType";
    public static final String PART = "part";
    public static final String OTHER = "other";
    public static final String UNIT_MEASURE_ID = "uomId";
    public static final String ALTER_VOUCHER_INITIAL = "USBA/C";
    public static final String STORE = "STORE";
    public static final String CLIENT_NAME = "clientName";
    public static final String IS_USED = "isUsed";
    public static final String PROCUREMENT_REQUISITION_ITEM ="procurementRequisitionItems" ;
    public static final String DEMAND_ITEM = "demandItem";
    public static final String PRIORITY = "priority";
    public static final String STORE_DEMAND = "storeDemand";
    public static final String AIRCRAFT = "aircraft";
    public static final String INTERNAL_DEPARTMENT = "internalDepartment";
    public static final String EXTERNAL_VENDOR = "vendor";
    /**
     * used for store user information
     */
    public static Map<Integer, Set<Integer>> roleMap = new HashMap<>();
    public static String SUCCESSFULLY_LOGOUT = "successfully logout";

    public static final String PHONE_NUMBER_VALIDATION = "([0-9]{1,20})";
    public static final String JASPER_REPORT_BASE_PATH = ResourceUtils.CLASSPATH_URL_PREFIX + "jasper_template/";
    public static final String META_DATA_BASE_PATH = "meta_data/";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CHARSET_UTF_8 = " charset=UTF-8";
    public static final String SEMICOLON = ";";
    public static final String PROPELLER_REPORT_PDF_FILE_NAME = "propeller_pdf.jrxml";

    public static final String ROOM_ID = "roomId";
    public static final String RACK_ID = "rackId";
    public static final String RACK_ROW_ID = "rackRowId";
    public static final String ENTITY_CODE = "code";
    public static final String GRN_NO = "grnNo";
    public static final String OFFICE_ID = "officeId";
    public static final String LOCATION_ID = "locationId";
    public static final String COUNTRY_NAME = "name";
    public static final String CITY_NAME = "name";
    public static final String COUNTRY_ID = "countryId";
    public static final String COMPANY_NAME = "companyName";
    public static final String CONFIG_MODULE_NAME = "moduleName";
    public static final String CONFIG_SUB_MODULE_NAME = "submoduleName";
    public static final String CONFIG_SUB_MODULE_ITEM_NAME = "itemName";
    public static final String LOCATION_ADDRESS = "address";
    public static final String CREATED_SUCCESSFULLY_MESSAGE = "Created Successfully";
    public static final String UPDATED_SUCCESSFULLY_MESSAGE = "Updated Successfully";
    public static final String VALIDITY_DATE_ADDED_SUCCESSFULLY = "Valid Till Date Updated Successfully";
    public static final String SUCCESSFULLY_PARTIALLY_APPROVED = "Partially Approved Successfully";
    public static final String COULD_NOT_PARSE_SHELF_LIFE_TYPE_FILE = "Could not parse self life type file";
    public static final String SH_LIFE_TYPE_DATE = "DATE";
    public static final String IS_ACTIVE_FIELD = "isActive";
    public static final String IS_REJECTED_FIELD = "isRejected";
    public static final String SUPPLIER_NAME = "name";
    public static final String SERIAL_NO = "serialNumber";
    public static final String SERIAL = "serial";
    public static final String GR_DATE = "grDate";
    public static final String VOUCHER_NO = "voucherNo";
    public static final String ORDER_NO = "orderNo";
    public static final String ORDER_TYPE = "orderType";
    public static final String IS_ISSUED = "isIssued";
    public static final String IS_REQUISITION = "isRequisition";
    public static final String IS_ALIVE = "isAlive";
    public static final String AIRCRAFT_NAME = "aircraftName";
    public static final String AIRCRAFT_MODEL_NAME = "aircraftModelName";
    public static final String RFQ_NO = "rfqNo";
    public static final String VENDOR = "name";
    public static final String WORKFLOW_ACTION_ID = "workFlowActionId";
    public static final String RELEASE_NO = "releaseNo";
    public static final String SHOW_FIELD = "show";
    public static final String PART_N0 = "partNo";
    public static final String QUOTATION_NO = "quotationNo";
    public static final String VENDOR_TYPE = "vendorType";
    public static final String QUOTE_REQUEST_ID = "quoteRequestId";
    public static final String STORE_DEMAND_ID = "storeDemandId";
    public static final String PART_ID ="partId";
    public static final String PART_STATUS="partStatus";

    public static final String PARENT_TYPE = "parentType";

    public static final String INSPECTION_NO = "inspectionNo";
    public static final int LIST_FIRST_INDEX = 0;
    public static final String EXCEL_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final int INT_ONE = 1;
    public static final int INT_NEGATIVE_ONE = -1;
    public static final int MAX_LIMIT = 2000;
    public static final String SEPARATOR = "#";
    public static final String JSON_EXTENSION = ".json";
    public static final String ROW_NUMBER = "ROW_NUMBER";
    public static final String DATE__TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String COMMA_SEPARATOR = ",";
    public static final String DOUBLE_ZERO_STRING = "0.0";
    public static final int MAX_FILE_FOLDER_SIZE = 128;
    public static final int YEAR_STARTING_VALUE = 20;

    public static final int MIN_FILE_FOLDER_SIZE = 1;
    /**
     * LIST index!
     */
    public static final int FIRST_INDEX = 0;
    public static final int SECOND_INDEX = 1;
    /**
     * Value One
     */
    public static final int VALUE_ONE = 1;
    public static final int VALUE_TWENTY = 20;
    public static final int VALUE_TWO = 2;
    public static final int VALUE_FOUR = 4;
    public static final int VALUE_ZERO = 0;
    public static final int VALUE_NINE = 9;

    public static final Double DOUBLE_VALUE_ZERO = 0.00;

    public static final String REQUISITION_NO = "requisitionNo";
    public static final String NAME = "name";
    public static final int  PASSWORD_LENGTH = 6;
    public static final String ALPHABET = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final Integer SUPER_ADMIN_ROLE_ID = 1;
    public static final Integer DEFAULT_PERMISSION_ID = 0;
    public static final Integer DEFAULT_SUCCESS_RESPONSE = 1;
    public static final Long OVERLOAD = 0L;

    public static final String RFQ_TYPE = "rfqType";
    public static class WORKFLOW_ACTION_ORDER {
        public static final Integer INITIAL_ORDER = 0;
    }

    public static class NUMBERS{
        public static final Integer ZERO = 0;
        public static final Integer ONE = 1;
        public static final Integer TWO = 2;
        public static final Integer THREE = 3;
        public static final Integer FOUR = 4;
        public static final Integer FIVE = 5;

    }

    public static final String TASK_SOURCE_AD = "AD";
    public static final String TASK_SOURCE_SB = "SB";
    public static final String TASK_SOURCE_AMP = "AMP";

    public static final String TASK_SOURCE_OTHER = "OTHERS";

    public static final String MEL = "MEL";

    public static final Set<String> otherTaskSource = Set.of(TASK_SOURCE_AMP,TASK_SOURCE_SB,TASK_SOURCE_AD);
    public static final String[] WHITE_LIST_URLS = new String[] {
            "/api/auth",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/",
            "/v3/api-docs/",
            "/swagger-ui/",
            "/api/erp/sync",
            "/erp"
    };
    public static final String[] WHITE_LIST_WILDCARDS = new String[]{
        "/v2/api-docs",
        "/swagger-resources",
        "/swagger-resources/**",
        "/configuration/ui",
        "/configuration/security",
        "/swagger-ui.html",
        "/webjars/**",
        "/v3/api-docs/**",
        "/swagger-ui/**"
    };

    public static final String ACCESS_RIGHTS_FILE_PATH = "access_rights.json";
    public static final String CREATED_DATE = "createdAt";
    public static final String DOT_REGEX = "\\.";
}
