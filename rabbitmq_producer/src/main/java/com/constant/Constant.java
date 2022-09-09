package com.constant;

public final class Constant {
    private Constant() {
    }

    public static final String ADMIN = "admin";
    public static final String FINANCE = "finance";
    public static final String MARKETING = "marketing";
    public static final String MARKETING_QUEUE = "marketingQueue";
    public static final String FINANCE_QUEUE = "financeQueue";
    public static final String ADMIN_QUEUE = "adminQueue";
    public static final String ALL_QUEUE = "allQueue";
    public static final String DIRECT_EXCHANGE = "direct-exchange";
    public static final String FANOUT_EXCHANGE = "fanout-exchange";
    public static final String TOPIC_EXCHANGE = "topic-exchange";
    public static final String QUEUE_MARKETING = "queue.marketing";
    public static final String QUEUE_ADMIN = "queue.admin";
    public static final String QUEUE_FINANCE = "queue.finance";
    public static final String QUEUE_ALL = "queue.*";
}
