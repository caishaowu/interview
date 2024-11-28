package com.bettercsw.strategy;


import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyh
 */
public class OrderConstant {

    //订单类型
    public class OrderType {
        public static final String NORMAL = "0";
        public static final String NORMAL_DESC = "正常订单";
    }

    public static Map<String, String> ORDER_TYPE_MAP = new HashMap<>();

    static {
        ORDER_TYPE_MAP.put(OrderType.NORMAL, OrderType.NORMAL_DESC);
    }

    //业务类型
    public class BizType {
        public static final String GOODSSER_ORDER = "1001";
        public static final String GOODSSER_ORDER_DESC = "商品订购";
        public static final String PRE_CANCEL_ACCOUNT = "1005";
        public static final String PRE_CANCEL_ACCOUNT_DESC = "预销户";
    }

    public static Map<String, String> BIZ_TYPE_MAP = new HashMap<>();

    static {
        BIZ_TYPE_MAP.put(BizType.GOODSSER_ORDER, BizType.GOODSSER_ORDER_DESC);
        BIZ_TYPE_MAP.put(BizType.PRE_CANCEL_ACCOUNT, BizType.PRE_CANCEL_ACCOUNT_DESC);
    }

    //统计时间
    public class CountTime {

        public static final String BEFORE_YESTERDAY = "00";
        public static final String BEFORE_YESTERDAY_DESC = "beforeYesterday";

        public static final String YESTERDAY = "01";
        public static final String YESTERDAY_DESC = "yesterday";
        public static final String LAST_WEEK = "02";
        public static final String LAST_WEEK_DESC = "lastWeek";
        public static final String LAST_MONTH = "03";
        public static final String LAST_MONTH_DESC = "lastMonth";
        public static final String LAST_QUARTER = "04";
        public static final String LAST_QUARTER_DESC = "lastQuarter";
        public static final String LAST_YEAR = "05";
        public static final String LAST_YEAR_DESC = "lastYear";

        public static final String TODAY = "11";
        public static final String TODAY_DESC = "today";
        public static final String WEEK = "12";
        public static final String WEEK_DESC = "thisWeek";
        public static final String MONTH = "13";
        public static final String MONTH_DESC = "thisMonth";
        public static final String QUARTER = "14";
        public static final String QUARTER_DESC = "thisQuarter";
        public static final String YEAR = "15";
        public static final String YEAR_DESC = "thisYear";

        public static final String ALL = "99";
        public static final String ALL_DESC = "all";

    }


    public static Map<String, String> COUNT_TIME_MAP = new HashMap<>();

    static {
        COUNT_TIME_MAP.put(CountTime.BEFORE_YESTERDAY, CountTime.BEFORE_YESTERDAY_DESC);
        COUNT_TIME_MAP.put(CountTime.TODAY, CountTime.TODAY_DESC);
        COUNT_TIME_MAP.put(CountTime.WEEK, CountTime.WEEK_DESC);
        COUNT_TIME_MAP.put(CountTime.MONTH, CountTime.MONTH_DESC);
        COUNT_TIME_MAP.put(CountTime.QUARTER, CountTime.QUARTER_DESC);
        COUNT_TIME_MAP.put(CountTime.YEAR, CountTime.YEAR_DESC);
        COUNT_TIME_MAP.put(CountTime.YESTERDAY, CountTime.YESTERDAY_DESC);
        COUNT_TIME_MAP.put(CountTime.LAST_WEEK, CountTime.LAST_WEEK_DESC);
        COUNT_TIME_MAP.put(CountTime.LAST_MONTH, CountTime.LAST_MONTH_DESC);
        COUNT_TIME_MAP.put(CountTime.LAST_QUARTER, CountTime.LAST_QUARTER_DESC);
        COUNT_TIME_MAP.put(CountTime.LAST_YEAR, CountTime.LAST_YEAR_DESC);
        COUNT_TIME_MAP.put(CountTime.ALL, CountTime.ALL_DESC);
    }

    //订单状态
    public class OrderStatus {
        public static final String CHECKIN = "1";
        public static final String CHECKIN_DESC = "订单入库";
        public static final String WAITPREOPEN = "2";
        public static final String WAITPREOPEN_DESC = "待预开通";
        public static final String WAITPAY = "3";
        public static final String WAITPAY_DESC = "待付款";
        public static final String WAITFINALOPEN = "5";
        public static final String WAITFINALOPEN_DESC = "待正式开通";
        public static final String WAITFEEDBACK = "7";
        public static final String WAITFEEDBACK_DESC = "待竣工反馈";
        public static final String FINISH = "10";
        public static final String FINISH_DESC = "已完成";
        public static final String CANCEL = "99";
        public static final String CANCEL_DESC = "已关闭";
        public static final String WAITBUSICANCEL = "91";
        public static final String WAITBUSICANCEL_DESC = "待业务取消";
    }

    public static Map<String, String> ORDER_STATUS_MAP = new HashMap<>();

    static {
        ORDER_STATUS_MAP.put(OrderStatus.CHECKIN, OrderStatus.CHECKIN_DESC);
        ORDER_STATUS_MAP.put(OrderStatus.WAITPREOPEN, OrderStatus.WAITPREOPEN_DESC);
        ORDER_STATUS_MAP.put(OrderStatus.WAITPAY, OrderStatus.WAITPAY_DESC);
        ORDER_STATUS_MAP.put(OrderStatus.WAITFINALOPEN, OrderStatus.WAITFINALOPEN_DESC);
        ORDER_STATUS_MAP.put(OrderStatus.WAITFEEDBACK, OrderStatus.WAITFEEDBACK_DESC);
        ORDER_STATUS_MAP.put(OrderStatus.FINISH, OrderStatus.FINISH_DESC);
        ORDER_STATUS_MAP.put(OrderStatus.CANCEL, OrderStatus.CANCEL_DESC);
        ORDER_STATUS_MAP.put(OrderStatus.WAITBUSICANCEL, OrderStatus.WAITBUSICANCEL_DESC);
    }

    //退货状态
    public class ReturnStatus {
        public static final String UNRETURNED = "0";
        public static final String UNRETURNED_DESC = "未退货";
        public static final String RETURNED = "1";
        public static final String RETURNED_DESC = "已退货";
    }

    //删除状态
    public class DeleteStatus {
        public static final String UNDELETED = "0";
        public static final String UNDELETED_DESC = "未删除";
        public static final String DELETED = "1";
        public static final String DELETED_DESC = "已删除";
    }

    //上次订单状态映射
    public static Map<String, String> LAST_ORDER_STATUS_MAP = new HashMap<>();

    static {
        LAST_ORDER_STATUS_MAP.put(OrderStatus.WAITFINALOPEN, OrderStatus.CHECKIN);
        LAST_ORDER_STATUS_MAP.put(OrderStatus.WAITFEEDBACK, OrderStatus.WAITFINALOPEN);
        LAST_ORDER_STATUS_MAP.put(OrderStatus.FINISH, OrderStatus.WAITFEEDBACK);
    }

    //允许开放给政企订单中心更新的订单状态
    public static Map<String, String> OPEN_UPDATE_ORDER_STATUS_MAP = new HashMap<>();

    static {
        OPEN_UPDATE_ORDER_STATUS_MAP.put(OrderStatus.WAITPAY, OrderStatus.WAITPAY_DESC);
        OPEN_UPDATE_ORDER_STATUS_MAP.put(OrderStatus.WAITFINALOPEN, OrderStatus.WAITPREOPEN_DESC);
    }

    //订单支付状态
    public class PayStatus {
        public static final String NONPAYMENT = "0";
        public static final String NONPAYMENT_DESC = "待支付";
        public static final String PAYMENT = "1";
        public static final String PAYMENT_DESC = "已支付";
        public static final String REFUNDED = "4";
        public static final String REFUNDED_DESC = "已退款";
    }

    public static Map<String, String> PAY_STATUS_MAP = new HashMap<>();

    static {
        PAY_STATUS_MAP.put(PayStatus.NONPAYMENT, PayStatus.NONPAYMENT_DESC);
        PAY_STATUS_MAP.put(PayStatus.PAYMENT, PayStatus.PAYMENT_DESC);
        PAY_STATUS_MAP.put(PayStatus.REFUNDED, PayStatus.REFUNDED_DESC);
    }

    //订单环节编码
    public class OrderNodeCode {
        public static final String COLLECTION = "collection";
        public static final String COLLECTION_DESC = "订单入库";
        public static final String PREBUSIOPEN = "preBusiOpen";
        public static final String PREBUSIOPEN_DESC = "业务预开通";
        public static final String PAYFEE = "payFee";
        public static final String PAYFEE_DESC = "支付";
        public static final String FINALBUSIOPEN = "finalBusiOpen";
        public static final String FINALBUSIOPEN_DESC = "业务正式开通";
        public static final String COMPLETED_FEEDBACK = "completedFeedback";
        public static final String COMPLETED_FEEDBACK_DESC = "竣工反馈";
        public static final String ORDERFINISH = "orderFinish";
        public static final String ORDERFINISH_DESC = "订单完成";
        public static final String BUSICANCEL = "busiCancel";
        public static final String BUSICANCEL_DESC = "业务取消";
    }

    public static Map<String, String> ORDER_NODE_CODE_MAP = new HashMap<>();

    static {
        ORDER_NODE_CODE_MAP.put(OrderNodeCode.COLLECTION, OrderNodeCode.COLLECTION_DESC);
        ORDER_NODE_CODE_MAP.put(OrderNodeCode.PREBUSIOPEN, OrderNodeCode.PREBUSIOPEN_DESC);
        ORDER_NODE_CODE_MAP.put(OrderNodeCode.PAYFEE, OrderNodeCode.PAYFEE_DESC);
        ORDER_NODE_CODE_MAP.put(OrderNodeCode.FINALBUSIOPEN, OrderNodeCode.FINALBUSIOPEN_DESC);
        ORDER_NODE_CODE_MAP.put(OrderNodeCode.COMPLETED_FEEDBACK, OrderNodeCode.COMPLETED_FEEDBACK_DESC);
        ORDER_NODE_CODE_MAP.put(OrderNodeCode.ORDERFINISH, OrderNodeCode.ORDERFINISH_DESC);
        ORDER_NODE_CODE_MAP.put(OrderNodeCode.BUSICANCEL, OrderNodeCode.BUSICANCEL_DESC);
    }

    //订单环节状态
    public class OrderNodeState {
        public static final String WAITE_PICKUP = "00";
        public static final String WAITE_PICKUP_DESC = "待领取";
        public static final String PENDING = "01";
        public static final String PENDING_DESC = "待处理";
        public static final String DEALED = "02";
        public static final String DEALED_DESC = "已处理";
        public static final String FAIL = "04";
        public static final String FAIL_DESC = "转异常";
    }

    public static Map<String, String> ORDER_NODE_STATE_MAP = new HashMap<>();

    static {
        ORDER_NODE_STATE_MAP.put(OrderNodeState.WAITE_PICKUP, OrderNodeState.WAITE_PICKUP_DESC);
        ORDER_NODE_STATE_MAP.put(OrderNodeState.PENDING, OrderNodeState.PENDING_DESC);
        ORDER_NODE_STATE_MAP.put(OrderNodeState.DEALED, OrderNodeState.DEALED_DESC);
        ORDER_NODE_STATE_MAP.put(OrderNodeState.FAIL, OrderNodeState.FAIL_DESC);
    }

    //合作伙伴钉钉的订单状态
    public class DingTalkOrderStatus {
        public static final String WAITOPEN = "3";
        public static final String WAITOPEN_DESC = "已支付";
        public static final String FINISH = "4";
        public static final String FINISH_DESC = "已完成";
        public static final String CANCEL = "1";
        public static final String CANCEL_DESC = "已取消";
    }

    public static Map<String, String> DING_TALK_ORDER_STATUS_MAP = new HashMap<>();

    static {
        DING_TALK_ORDER_STATUS_MAP.put(DingTalkOrderStatus.WAITOPEN, DingTalkOrderStatus.WAITOPEN_DESC);
        DING_TALK_ORDER_STATUS_MAP.put(DingTalkOrderStatus.FINISH, DingTalkOrderStatus.FINISH_DESC);
        DING_TALK_ORDER_STATUS_MAP.put(DingTalkOrderStatus.CANCEL, DingTalkOrderStatus.CANCEL_DESC);
    }

    //订单商品交付状态
    public class DeliverStatus {
        public static final String WAITDELIVER = "0";
        public static final String WAITDELIVER_DESC = "未开通/未交付";
        public static final String DELIVERING = "1";
        public static final String DELIVERING_DESC = "开通中/交付中";
        public static final String DELIVERED = "2";
        public static final String DELIVERED_DESC = "已开通/已交付";
        public static final String DELIVERFAIL = "4";
        public static final String DELIVERFAIL_DESC = "开通失败/交付失败";
        public static final String NODELIVER = "99";
        public static final String NODELIVER_DESC = "无需开通/无需交付";
    }

    public static Map<String, String> DELIVER_STATUS_MAP = new HashMap<>();

    static {
        DELIVER_STATUS_MAP.put(DeliverStatus.WAITDELIVER, DeliverStatus.WAITDELIVER_DESC);
        DELIVER_STATUS_MAP.put(DeliverStatus.DELIVERING, DeliverStatus.DELIVERING_DESC);
        DELIVER_STATUS_MAP.put(DeliverStatus.DELIVERED, DeliverStatus.DELIVERED_DESC);
        DELIVER_STATUS_MAP.put(DeliverStatus.DELIVERFAIL, DeliverStatus.DELIVERFAIL_DESC);
        DELIVER_STATUS_MAP.put(DeliverStatus.NODELIVER, DeliverStatus.NODELIVER_DESC);
    }

    //订单流程类型
    public class OrderProcessType {
        public static final String ORDERPROCESS = "ORDERPROCESS";
        public static final String ORDERPROCESS_DESC = "订购流程";
        public static final String RETURNPROCESS = "RETURNPROCESS";
        public static final String RETURNPROCESS_DESC = "退单流程";
        public static final String CANCELPROCESS = "CANCELPROCESS";
        public static final String CANCELPROCESS_DESC = "销户流程";
    }

    //商品订购流程
    public class GoodsOrderProcess {
        public static final String DINGSAASOPEN = "eco_dingSaasOpen";
        public static final String DINGSAASOPEN_DESC = "钉钉SAAS产品开通流程";
        public static final String DINGSAASCANCEL = "eco_dingSaasCancel";
        public static final String DINGSAASCANCEL_DESC = "钉钉SAAS产品销户流程";
        public static final String AUTODIRECTFEEDBACK = "eco_autoDirectFeedback";
        public static final String AUTODIRECTFEEDBACK_DESC = "自动直接竣工反馈流程";
        public static final String MANUALFEEDBACK = "eco_manualFeedback";
        public static final String MANUALFEEDBACK_DESC = "人工竣工反馈流程";
    }

    //订单反馈受理类型
    public class OrderFeedbackAcceptType {
        public static final String BUSIOPEN = "1";
        public static final String BUSIOPEN_DESC = "业务开通";
    }

    public static Map<String, String> ORDER_FEEDBACK_ACCEPT_TYPE_MAP = new HashMap<>();

    static {
        ORDER_FEEDBACK_ACCEPT_TYPE_MAP.put(OrderFeedbackAcceptType.BUSIOPEN, OrderFeedbackAcceptType.BUSIOPEN_DESC);
    }

    //订单受理结果
    public class OrderAcceptResult {
        public static final String SUCCESS = "0";
        public static final String SUCCESS_DESC = "成功";
        public static final String FAIL = "1";
        public static final String FAIL_DESC = "失败";
    }

    // 触点来源
    public class Mall {
        public static final String ORDERCENTER = "1";
        public static final String ORDERCENTER_DESC = "政企订单中心";
        public static final String ASSISTANT = "2";
        public static final String ASSISTANT_DESC = "政企助手";
    }

    public static Map<String, String> MALL_MAP = new HashMap<>();

    static {
        MALL_MAP.put(Mall.ORDERCENTER, Mall.ORDERCENTER_DESC);
        MALL_MAP.put(Mall.ASSISTANT, Mall.ASSISTANT_DESC);
    }

}

