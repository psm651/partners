package com.earnmoneynow.partners.global.error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    /**
     * ---- 서버 에러 분류 (890,000 ~ ) ----
     * common        : 890,000
     * 인증          : 891,000
     * 권한          : 892,00
     * 요청 파라미터 관련
     * > 필터        : 893,000
     * > 정렬        : 893,100
     * SQL          : 894,000
     * <p>
     * ---- 서비스 단위 분류 (800,000 ~ ) ----
     * virtual_host : 800,000
     * member       : 801,000
     * organization : 802,000
     * space        : 803,000
     * space member : 804,000
     * board        : 805,000
     * section      : 806,000
     * label        : 807,000
     * card         : 808,000
     * checklist    : 809,000
     * card label   : 810,000
     * assignee     : 811.000
     * subscription : 812,000
     * comment      : 813,000
     * action       : 814.000
     * attachment   : 815,000
     * batch        : 816,000
     * tutorial     : 817,000
     */

    //-----------------------------------------서버 에러 분류 (890,000 ~ )-----------------------------------------
    // common : 890,000
    INVALID_INPUT_VALUE(890000, "Invalid input value"),
    UNAUTHORIZED(890001, "Unauthorized access"),
    METHOD_NOT_ALLOWED(890002, "Method not allowed"),
    ENTITY_NOT_FOUND(890003, "Entity not found"),
    REQUEST_REJECTED(890004, "Invalid request url"),
    NUMBER_FORMAT_EXCEPTION(890005, "Number format exception"),
    REQUEST_FAILED(890006, "Request failed"),
    RESPONSE_STATUS_CODE_IS_NOT_200(890007, "Response status code is not 200"),
    CONTENT_TYPE_NOT_ALLOWED(890008, "Content-type not allowed"),

    // 인증 : 891,000
    AUTHORIZATION_HEADER_NOT_FOUND(891000, "Authorization header not found"),
    INVALID_AUTHENTICATION_TYPE(891001, "Unsupported authentication type"),
    INVALID_TOKEN(891002, "Invalid token"),
    EXPIRED_TOKEN(891003, "Expired token"),
    UNKNOWN_USER(891004, "Unknown user"),
    UNKNOWN_VIRTUAL_HOST(891005, "Unknown virtual host"),

    // 권한 : 892,000
    GROUPWARE_ADMIN_PERMISSION(892000, "You don't have permission to groupware administrator privileges"),
    SPACE_ADMIN_PERMISSION(892001, "You don't have permission to space administrator privileges"),
    SPACE_ACCESS_PERMISSION(892002, "You don't have permission to space access"),
    TASK_SCOPE_NOT_FOUND(892003, "User does not have permission to use task"),

    // 요청 파라미터 관련
    // 필터 : 893,000
    FILTER_ENTITY_NOT_FOUND(893000, "Filter - Entity not found"),
    FILTER_PROPERTY_NOT_FOUND(893001, "Filter - Property not found"),
    FILTER_INVALID_OPERATOR(893002, "Filter - Invalid operator"),
    FILTER_QUERY_DSL_EXCEPTION(893003, "Filter - QueryDSL exception"),
    FILTER_DATA_FORMAT_EXCEPTION(893004, "Filter - Value data format exception"),
    FILTER_INVALID_INPUT_VALUE(893005, "Filter - Invalid input value"),
    FILTER_TRUNCATE_SIZE(893006, "Filter - Truncate size must be greater than 0."),

    // 정렬 : 893,100
    SORT_INVALID_TARGET(893100, "Sort - Invalid sort target"),

    // SQL : 894,000
    UNIQUE_CONSTRAINT_VIOLATION(894000, "Duplicate key value violates unique constraint"),

    // Request : 895,000
    REQUEST_TO_SEND_QUOTA_MAIL_FAILED(895000, "Request to send quota mail failed."),
    REQUEST_TO_GET_GW_ADMIN_LIST_FAILED(895001, "Request to get groupware admin list failed"),
    MAIL_RESOURCE_URL_NOT_FOUND(895002, "Failed to find mail resource url"),
    WEBCLIENT_REQUEST_FAIL(895003, "webclient request error"), NOT_ALLOWED_METHOD(895004,"error" );
    //-----------------------------------------------------------------------------------------------------------

    private final int code;
    private final String message;

    ErrorCode(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorCode valueOfOrNull(String name) {
        try {
            return valueOf(name);
        } catch (Exception e) {
            return null;
        }
    }
}
