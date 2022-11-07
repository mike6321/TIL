package net.fashiongo.api.common.model.command;

public class RequestContext {

    private static final ThreadLocal<RequestHeaderInfo> requestHeaderInfoThreadLocal = new ThreadLocal<>();

    public static RequestHeaderInfo getRequestHeaderInfo() {
        return requestHeaderInfoThreadLocal.get();
    }

    public static String getApplicationType() {
        return requestHeaderInfoThreadLocal.get().getApplicationType();
    }

    public static String getRequestId() {
        return requestHeaderInfoThreadLocal.get().getRequestId();
    }

    public static UserInfo getUserInfo() {
        return requestHeaderInfoThreadLocal.get().getUserInfo();
    }

    public static String getUserId() {
        return requestHeaderInfoThreadLocal.get().getUserInfo().getUserId();
    }

    public static String getUsername() {
        return requestHeaderInfoThreadLocal.get().getUserInfo().getUsername();
    }

    public static Long getVendorId() {
        return requestHeaderInfoThreadLocal.get().getVendorId();
    }

    public static void create(String applicationType, String requestId, UserInfo userInfo, Long vendorId) {
        requestHeaderInfoThreadLocal.set(RequestHeaderInfo.create(applicationType, requestId, userInfo, vendorId));
    }

    public static void setUserInfo(UserInfo userInfo) {
        requestHeaderInfoThreadLocal.get().setUserInfo(userInfo);
    }

    public static void remove() {
        requestHeaderInfoThreadLocal.remove();
    }
}
