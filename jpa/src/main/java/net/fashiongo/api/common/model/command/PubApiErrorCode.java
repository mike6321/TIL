package net.fashiongo.api.common.model.command;

import lombok.Getter;

@Getter
public enum PubApiErrorCode {

    // vendors
    INVALID_VENDOR(6000, "Vendor is invalid"),
    VENDOR_NOT_EXIST(6001, "Vendor doesn't exist"),
    VENDOR_INFO_NOT_EXIST(6002, "Vendor info doesn't exist"),
    VENDOR_NOT_MATCHED(6003, "Vendor name and requested company name not matched"),
    RETAILER_CREATE_FAILED(6004, "Vendor retailer create failed"),

    // orders
    ORDER_NOT_EXIST(7000, "Order doesn't exist"),
    ORDER_NOT_FOUND(7001, "Order not found"),
    ORDER_ALREADY_CANCELLED(7002, "Not allowed operation for cancelled order"),
    NOT_ALLOWED_FOR_MERGED_ORDER(7003, "Not allowed operation for merged order"),
    ORDER_ALREADY_SHIPPED(7004, "Not allowed operation for shipped order"),
    ALLOWED_ONLY_FOR_NEW_ORDER(7005, "Operation allowed only for new order"),
    VENDOR_ORDER_SHIP_METHOD_NOT_EXIST(7006, "Order shipping method does not exist"),
    FG_ORDER_SHIP_METHOD_NOT_EXIST(7007, "FashionGo order shipping method does not exist"),
    ORDER_PAYMENT_NOT_COMPLETED(7008, "Order payment not completed"),
    ORDER_NOT_CONFIRMED(7009, "Order not confirmed yet"),
    ORDER_PAYMENT_NOT_EXIST(7010, "Order payment not exists"),
    ORDER_PAYMENT_NOT_READY(7011, "Order payment not ready"),
    ORDER_PAYMENT_AUTH_FAILED(7012, "Order payment authorization failed"),
    ORDER_PAYMENT_NOT_AUTHORIZED(7013, "Order payment not authorized"),
    ORDER_PAYMENT_CAPTURE_FAILED(7014, "Order payment capture failed"),
    ORDER_PAYMENT_CAPTURE_AUTH_FAILED(7015, "Order payment capture & auth failed"),
    NOT_ALLOWED_FOR_WITHDRAWAL_BUYER(7016, "Order payment or shipment not allowed for withdrawal buyer"),

    // products
    PRODUCT_NOT_FOUND(8000, "Product not found"),
    STYLE_CODE_ALREADY_EXIST(8001, "Style code already exists"),
    VENDOR_CATEGORY_NOT_EXIST(8002, "Vendor category id doesn't exist"),
    LIST_PRICE_MUST_BE_GREATER_THAN_SELL_PRICE(8003, "Listing price should not be less than selling price"),
    INVENTORY_NOT_EXIST(8004, "Product inventory doesn't exist"),
    PRODUCT_IMAGE_NOT_EXIST(8005, "Product image doesn't exist"),
    INVALID_CROSS_SELL_PRODUCT(8006, "Cross sell product is inactive or id is not greater than 0"),
    PACK_ID_ABSENT(8007, "Pack id is absent"),
    VENDOR_SIZE_INFO_NOT_EXIST(8008, "Vendor product size info doesn't exist"),
    SELLING_PRICE_CANNOT_BE_NULL(8009, "Selling price cannot be null to activate product"),
    INVALID_PRODUCT_DESCRIPTION(8010, "Product description is invalid"),
    INVALID_PRODUCT_SEARCH_KEYWORD(8011, "Product search keyword is invalid"),
    VENDOR_CATEGORY_IS_NULL(8012, "Request vendor category is null"),
    NON_NULL_PRODUCT_PARAMETER_REQUIRED(8013, "Null parameter not allowed for product"),
    PRODUCT_HAS_ORDER(8014, "Product having order cannot be deleted"),
    PRODUCT_CREATE_FAIL(8015, "Product creation failed"),
    BULK_JOB_NOT_FOUND(8016, "BulkJob not found"),
    SIZE_ID_NOT_EXIST_FOR_SINGLE_PACK(8017, "This item is single pack item, but sizeId is not Existed"),
    SIZE_ID_NOT_MATCH_TO_VENDOR(8018, "Vendor doesn't have this size id"),
    SIZE_NAME_NEEDED(8019, "Product is not prePack, so size name needed"),
    INVALID_AVAILABLE_ON(8020, "AvailableOn cannot be null when statusCode is 3 (Arrive Soon)"),
    COLOR_NOT_EXIST_OR_INACTIVE(8021, "Vendor color not existed or inactive"),
    PRODUCT_BULK_JOB_FAILED(8022, "Product bulk job failed"),
    INVALID_SIZE_NAME(8023, "Size name does not belong to size id"),
    SIZE_NAME_SHOULD_BE_NULL(8024, "Inventory size name should be null for prePack product"),

    // color
    COLOR_ALREADY_EXIST(8500, "Color already exists"),
    COLOR_NOT_FOUND(8501, "Color not found"),
    COLOR_NAME_IN_USE(8502, "Color name already in use, so cannot be modified"),

    // image
    IMAGE_NOT_FOUND(8600, "Image not found"),
    FIRST_IMAGE_CANNOT_BE_DELETED(8601, "First image cannot be deleted"),
    IMAGE_NOT_EXIST(8602, "Product image doesn't exist"),
    IMAGE_ID_NOT_MATCHED(8603, "Provided item image ids not matched."),
    INVALID_IMAGE_EXTENSION(8604, "The image should be jpeg, png, gif, or svg only."),
    ITEM_IMAGE_MAX(8605, "An item cannot get over 20 images."),
    IMAGE_UPLOAD_FAILED(8606, "Image upload api failed.")

    ;

    private final Integer code;
    private final String message;

    PubApiErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
