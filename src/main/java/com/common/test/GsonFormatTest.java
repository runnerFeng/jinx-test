package com.common.test;

/**
 * @author jinx
 * @date 2017/12/19 17:05
 * Desc:GsonFormatTest
 */
public class GsonFormatTest {


    /**
     * code : 0
     * message : 查询成功
     * data : {"process_change_shareholder":"权益性质变更[股东发起]","process_pledge_freeze_shareholder":"份额质押[股东发起]","process_modify_info_shareholder":"信息变更[股东]","process_transfer_shareholder":"非交易过户[股东发起]","process_pledge_unfreeze_shareholder":"份额解押[股东发起]","process_add_equity":"增资扩股","process_change_ent":"权益性质变更[企业发起]","process_registration":"股权登记","process_pledge_freeze_ent":"份额质押[企业发起]","process_pledge_unfreeze_ent":"份额解押[企业发起]","process_freeze":"司法冻结","process_modify_list":"修改股东名册","process_unfreeze":"司法解冻","process_modify_product_info":"产品信息修改","process_modify_info_ent":"信息变更[企业]","process_transfer_ent":"非交易过户[企业发起]","process_share_change":"股东份额调整"}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * process_change_shareholder : 权益性质变更[股东发起]
         * process_pledge_freeze_shareholder : 份额质押[股东发起]
         * process_modify_info_shareholder : 信息变更[股东]
         * process_transfer_shareholder : 非交易过户[股东发起]
         * process_pledge_unfreeze_shareholder : 份额解押[股东发起]
         * process_add_equity : 增资扩股
         * process_change_ent : 权益性质变更[企业发起]
         * process_registration : 股权登记
         * process_pledge_freeze_ent : 份额质押[企业发起]
         * process_pledge_unfreeze_ent : 份额解押[企业发起]
         * process_freeze : 司法冻结
         * process_modify_list : 修改股东名册
         * process_unfreeze : 司法解冻
         * process_modify_product_info : 产品信息修改
         * process_modify_info_ent : 信息变更[企业]
         * process_transfer_ent : 非交易过户[企业发起]
         * process_share_change : 股东份额调整
         */

        private String process_change_shareholder;
        private String process_pledge_freeze_shareholder;
        private String process_modify_info_shareholder;
        private String process_transfer_shareholder;
        private String process_pledge_unfreeze_shareholder;
        private String process_add_equity;
        private String process_change_ent;
        private String process_registration;
        private String process_pledge_freeze_ent;
        private String process_pledge_unfreeze_ent;
        private String process_freeze;
        private String process_modify_list;
        private String process_unfreeze;
        private String process_modify_product_info;
        private String process_modify_info_ent;
        private String process_transfer_ent;
        private String process_share_change;

        public String getProcess_change_shareholder() {
            return process_change_shareholder;
        }

        public void setProcess_change_shareholder(String process_change_shareholder) {
            this.process_change_shareholder = process_change_shareholder;
        }

        public String getProcess_pledge_freeze_shareholder() {
            return process_pledge_freeze_shareholder;
        }

        public void setProcess_pledge_freeze_shareholder(String process_pledge_freeze_shareholder) {
            this.process_pledge_freeze_shareholder = process_pledge_freeze_shareholder;
        }

        public String getProcess_modify_info_shareholder() {
            return process_modify_info_shareholder;
        }

        public void setProcess_modify_info_shareholder(String process_modify_info_shareholder) {
            this.process_modify_info_shareholder = process_modify_info_shareholder;
        }

        public String getProcess_transfer_shareholder() {
            return process_transfer_shareholder;
        }

        public void setProcess_transfer_shareholder(String process_transfer_shareholder) {
            this.process_transfer_shareholder = process_transfer_shareholder;
        }

        public String getProcess_pledge_unfreeze_shareholder() {
            return process_pledge_unfreeze_shareholder;
        }

        public void setProcess_pledge_unfreeze_shareholder(String process_pledge_unfreeze_shareholder) {
            this.process_pledge_unfreeze_shareholder = process_pledge_unfreeze_shareholder;
        }

        public String getProcess_add_equity() {
            return process_add_equity;
        }

        public void setProcess_add_equity(String process_add_equity) {
            this.process_add_equity = process_add_equity;
        }

        public String getProcess_change_ent() {
            return process_change_ent;
        }

        public void setProcess_change_ent(String process_change_ent) {
            this.process_change_ent = process_change_ent;
        }

        public String getProcess_registration() {
            return process_registration;
        }

        public void setProcess_registration(String process_registration) {
            this.process_registration = process_registration;
        }

        public String getProcess_pledge_freeze_ent() {
            return process_pledge_freeze_ent;
        }

        public void setProcess_pledge_freeze_ent(String process_pledge_freeze_ent) {
            this.process_pledge_freeze_ent = process_pledge_freeze_ent;
        }

        public String getProcess_pledge_unfreeze_ent() {
            return process_pledge_unfreeze_ent;
        }

        public void setProcess_pledge_unfreeze_ent(String process_pledge_unfreeze_ent) {
            this.process_pledge_unfreeze_ent = process_pledge_unfreeze_ent;
        }

        public String getProcess_freeze() {
            return process_freeze;
        }

        public void setProcess_freeze(String process_freeze) {
            this.process_freeze = process_freeze;
        }

        public String getProcess_modify_list() {
            return process_modify_list;
        }

        public void setProcess_modify_list(String process_modify_list) {
            this.process_modify_list = process_modify_list;
        }

        public String getProcess_unfreeze() {
            return process_unfreeze;
        }

        public void setProcess_unfreeze(String process_unfreeze) {
            this.process_unfreeze = process_unfreeze;
        }

        public String getProcess_modify_product_info() {
            return process_modify_product_info;
        }

        public void setProcess_modify_product_info(String process_modify_product_info) {
            this.process_modify_product_info = process_modify_product_info;
        }

        public String getProcess_modify_info_ent() {
            return process_modify_info_ent;
        }

        public void setProcess_modify_info_ent(String process_modify_info_ent) {
            this.process_modify_info_ent = process_modify_info_ent;
        }

        public String getProcess_transfer_ent() {
            return process_transfer_ent;
        }

        public void setProcess_transfer_ent(String process_transfer_ent) {
            this.process_transfer_ent = process_transfer_ent;
        }

        public String getProcess_share_change() {
            return process_share_change;
        }

        public void setProcess_share_change(String process_share_change) {
            this.process_share_change = process_share_change;
        }
    }

}
