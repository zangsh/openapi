package com.mw.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FJson {
    public static void main(String[] args) {
        String json = "{\n" +
                "    \"user\": \"factoryAdmin\",\n" +
                "    \"password\": \"admin\",\n" +
                "    \"count\": \"20\",\n" +
                "    \"record\": {\n" +
                "        \"data\": [\n" +
                "            {\n" +
                "            \t\"test\": \"8\",\n" +
                "                \"WAGE\": 11,\n" +
                "                \"PART_NO\": \"11320001-BVT01005205[C01]\",\n" +
                "                \"DEMAND_QTY\": 48,\n" +
                "                \"BOARD_COUNT\": 1,\n" +
                "                \"BAOG_USERS\": \"1126;1182;1367\",\n" +
                "                \"CUT_STATE\": \"已切割\",\n" +
                "                \"WORK_NO\": \"20170906-5\",\n" +
                "                \"ACT_WEIGHT\": 4.87,\n" +
                "                \"BAOG_OK_QTY\": 46,\n" +
                "                \"SALE_LINE_NO\": \"6\",\n" +
                "                \"ORDER_STATUS_NAME\": \"开工\",\n" +
                "                \"PLATE_THICKNESS\": 20,\n" +
                "                \"CUT_BEGIN_TIME\": \"2017-09-07 16:27:46\",\n" +
                "                \"PART_NAME_DES\": \"29059392.dwg-20170410111727057.dwg_20170417181422074\",\n" +
                "                \"CREATE_DATE\": \"2017-09-06T16:47:00\",\n" +
                "                \"PLANT_NAME\": \"苏州澳克机械有限公司\",\n" +
                "                \"PATH_NAME\": \"等离子切割\",\n" +
                "                \"BAOG_NG_QTY\": 2,\n" +
                "                \"PRO_NAME\": \"程序20170906003\",\n" +
                "                \"CUT_MODE\": \"51990022\",\n" +
                "                \"CREATE_BY\": \"723fe89f9e04417f9d4fc6e506ee1ac7\",\n" +
                "                \"CUT_COUNT\": 1,\n" +
                "                \"PRO_LINE_NO\": \"5\",\n" +
                "                \"LINE_NAME\": \"CT01\",\n" +
                "                \"SAND_STATE\": \"未打磨\",\n" +
                "                \"BOARD_USER\": \"723fe89f9e04417f9d4fc6e506ee1ac7\",\n" +
                "                \"EQUIPMENT_NO\": \"EM_MSE_D001\",\n" +
                "                \"COST_WEIGHT\": 6.51,\n" +
                "                \"TO_ORDER_ID\": \"90a4df64db444cf79a7fe1f0af708fb0\",\n" +
                "                \"BOARD_TIME\": \"2017-09-07 16:27:40\",\n" +
                "                \"CUT_LENGTH\": 1071.8,\n" +
                "                \"RATE\": \"55%\",\n" +
                "                \"ORDER_NO\": \"20170906\",\n" +
                "                \"HEAT_NO\": \"L201709071627\",\n" +
                "                \"CUT_TIME\": 1.28,\n" +
                "                \"PROCESS_NAME\": \"切割\",\n" +
                "                \"INVENTORY_CODE\": \"11320001-BVT01005205[C01]\",\n" +
                "                \"PQC_BAOGONG\": [\n" +
                "                    {\n" +
                "                        \"WAGE\": 55,\n" +
                "                        \"ErrorNAME\": \"内孔尺寸\",\n" +
                "                        \"QTY\": 2,\n" +
                "                        \"PQC_RESULT_STATUS\": \"NG\",\n" +
                "                        \"LCMSN\": \"20170906-5-1\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"ACT_QTY\": 48,\n" +
                "                \"MATERIAL\": \"Q345D钢板_Z25\",\n" +
                "                \"LCMSN\": \"20170906-5-1\",\n" +
                "                \"CUT_END_TIME\": \"2017-09-07 16:28:34\",\n" +
                "                \"SALE_NO\": \"3820542064640011\",\n" +
                "                \"PRO_VERSION\": \"A0003\",\n" +
                "                \"TM_PATH_ID\": \"50e29d516c8f47469df4d55618dac0c1\",\n" +
                "                \"CUSTOMER_NO\": \"11320001\",\n" +
                "                \"SHARE_RATE\": \"0.95\",\n" +
                "                \"MATERIAL_CODE\": \"51023424-0200\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"test\": \"8\",\n" +
                "                \"WAGE\": 11,\n" +
                "                \"PART_NO\": \"11320001-BVT01005205[C01]\",\n" +
                "                \"DEMAND_QTY\": 48,\n" +
                "                \"BOARD_COUNT\": 1,\n" +
                "                \"BAOG_USERS\": \"1126;1182;1367\",\n" +
                "                \"CUT_STATE\": \"已切割\",\n" +
                "                \"WORK_NO\": \"20170906-5\",\n" +
                "                \"ACT_WEIGHT\": 4.87,\n" +
                "                \"BAOG_OK_QTY\": 46,\n" +
                "                \"SALE_LINE_NO\": \"6\",\n" +
                "                \"ORDER_STATUS_NAME\": \"开工\",\n" +
                "                \"PLATE_THICKNESS\": 20,\n" +
                "                \"CUT_BEGIN_TIME\": \"2017-09-07 16:27:46\",\n" +
                "                \"PART_NAME_DES\": \"29059392.dwg-20170410111727057.dwg_20170417181422074\",\n" +
                "                \"CREATE_DATE\": \"2017-09-06T16:47:00\",\n" +
                "                \"PLANT_NAME\": \"苏州澳克机械有限公司\",\n" +
                "                \"PATH_NAME\": \"等离子切割\",\n" +
                "                \"BAOG_NG_QTY\": 2,\n" +
                "                \"PRO_NAME\": \"程序20170906003\",\n" +
                "                \"CUT_MODE\": \"51990022\",\n" +
                "                \"CREATE_BY\": \"723fe89f9e04417f9d4fc6e506ee1ac7\",\n" +
                "                \"CUT_COUNT\": 1,\n" +
                "                \"PRO_LINE_NO\": \"5\",\n" +
                "                \"LINE_NAME\": \"CT01\",\n" +
                "                \"SAND_STATE\": \"未打磨\",\n" +
                "                \"BOARD_USER\": \"723fe89f9e04417f9d4fc6e506ee1ac7\",\n" +
                "                \"EQUIPMENT_NO\": \"EM_MSE_D001\",\n" +
                "                \"COST_WEIGHT\": 6.51,\n" +
                "                \"TO_ORDER_ID\": \"90a4df64db444cf79a7fe1f0af708fb0\",\n" +
                "                \"BOARD_TIME\": \"2017-09-07 16:27:40\",\n" +
                "                \"CUT_LENGTH\": 1071.8,\n" +
                "                \"RATE\": \"55%\",\n" +
                "                \"ORDER_NO\": \"20170906\",\n" +
                "                \"HEAT_NO\": \"L201709071627\",\n" +
                "                \"CUT_TIME\": 1.28,\n" +
                "                \"PROCESS_NAME\": \"切割\",\n" +
                "                \"INVENTORY_CODE\": \"11320001-BVT01005205[C01]\",\n" +
                "                \"PQC_BAOGONG\": [\n" +
                "                    {\n" +
                "                        \"WAGE\": 55,\n" +
                "                        \"ErrorNAME\": \"内孔尺寸\",\n" +
                "                        \"QTY\": 2,\n" +
                "                        \"PQC_RESULT_STATUS\": \"NG\",\n" +
                "                        \"LCMSN\": \"20170906-5-1\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"ACT_QTY\": 48,\n" +
                "                \"MATERIAL\": \"Q345D钢板_Z25\",\n" +
                "                \"LCMSN\": \"20170906-5-1\",\n" +
                "                \"CUT_END_TIME\": \"2017-09-07 16:28:34\",\n" +
                "                \"SALE_NO\": \"3820542064640011\",\n" +
                "                \"PRO_VERSION\": \"A0003\",\n" +
                "                \"TM_PATH_ID\": \"50e29d516c8f47469df4d55618dac0c1\",\n" +
                "                \"CUSTOMER_NO\": \"11320001\",\n" +
                "                \"SHARE_RATE\": \"0.95\",\n" +
                "                \"MATERIAL_CODE\": \"51023424-0200\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"test\": \"8\",\n" +
                "                \"WAGE\": 11,\n" +
                "                \"PART_NO\": \"11320001-BVT01005205[C01]\",\n" +
                "                \"DEMAND_QTY\": 48,\n" +
                "                \"BOARD_COUNT\": 1,\n" +
                "                \"BAOG_USERS\": \"1126;1182;1367\",\n" +
                "                \"CUT_STATE\": \"已切割\",\n" +
                "                \"WORK_NO\": \"20170906-5\",\n" +
                "                \"ACT_WEIGHT\": 4.87,\n" +
                "                \"BAOG_OK_QTY\": 46,\n" +
                "                \"SALE_LINE_NO\": \"6\",\n" +
                "                \"ORDER_STATUS_NAME\": \"开工\",\n" +
                "                \"PLATE_THICKNESS\": 20,\n" +
                "                \"CUT_BEGIN_TIME\": \"2017-09-07 16:27:46\",\n" +
                "                \"PART_NAME_DES\": \"29059392.dwg-20170410111727057.dwg_20170417181422074\",\n" +
                "                \"CREATE_DATE\": \"2017-09-06T16:47:00\",\n" +
                "                \"PLANT_NAME\": \"苏州澳克机械有限公司\",\n" +
                "                \"PATH_NAME\": \"等离子切割\",\n" +
                "                \"BAOG_NG_QTY\": 2,\n" +
                "                \"PRO_NAME\": \"程序20170906003\",\n" +
                "                \"CUT_MODE\": \"51990022\",\n" +
                "                \"CREATE_BY\": \"723fe89f9e04417f9d4fc6e506ee1ac7\",\n" +
                "                \"CUT_COUNT\": 1,\n" +
                "                \"PRO_LINE_NO\": \"5\",\n" +
                "                \"LINE_NAME\": \"CT01\",\n" +
                "                \"SAND_STATE\": \"未打磨\",\n" +
                "                \"BOARD_USER\": \"723fe89f9e04417f9d4fc6e506ee1ac7\",\n" +
                "                \"EQUIPMENT_NO\": \"EM_MSE_D001\",\n" +
                "                \"COST_WEIGHT\": 6.51,\n" +
                "                \"TO_ORDER_ID\": \"90a4df64db444cf79a7fe1f0af708fb0\",\n" +
                "                \"BOARD_TIME\": \"2017-09-07 16:27:40\",\n" +
                "                \"CUT_LENGTH\": 1071.8,\n" +
                "                \"RATE\": \"55%\",\n" +
                "                \"ORDER_NO\": \"20170906\",\n" +
                "                \"HEAT_NO\": \"L201709071627\",\n" +
                "                \"CUT_TIME\": 1.28,\n" +
                "                \"PROCESS_NAME\": \"切割\",\n" +
                "                \"INVENTORY_CODE\": \"11320001-BVT01005205[C01]\",\n" +
                "                \"PQC_BAOGONG\": [\n" +
                "                    {\n" +
                "                        \"WAGE\": 55,\n" +
                "                        \"ErrorNAME\": \"内孔尺寸\",\n" +
                "                        \"QTY\": 2,\n" +
                "                        \"PQC_RESULT_STATUS\": \"NG\",\n" +
                "                        \"LCMSN\": \"20170906-5-1\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"ACT_QTY\": 48,\n" +
                "                \"MATERIAL\": \"Q345D钢板_Z25\",\n" +
                "                \"LCMSN\": \"20170906-5-1\",\n" +
                "                \"CUT_END_TIME\": \"2017-09-07 16:28:34\",\n" +
                "                \"SALE_NO\": \"3820542064640011\",\n" +
                "                \"PRO_VERSION\": \"A0003\",\n" +
                "                \"TM_PATH_ID\": \"50e29d516c8f47469df4d55618dac0c1\",\n" +
                "                \"CUSTOMER_NO\": \"11320001\",\n" +
                "                \"SHARE_RATE\": \"0.95\",\n" +
                "                \"MATERIAL_CODE\": \"51023424-0200\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"tableName\": \"TM_PROCESS_BAOGONG\",\n" +
                "        \"timestamp\": \"2017-09-07 16:28:47.388\"\n" +
                "    }\n" +
                "}";
        System.out.println(compress(json));
    }

    public static String compress(String json) {
        if (json == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean skip = true;// true 允许截取(表示未进入string双引号)
        boolean escaped = false;// 转义符
        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            if (!escaped && c == '\\') {
                escaped = true;
            } else {
                escaped = false;
            }
            if (skip) {
                if (c == ' ' || c == '\r' || c == '\n' || c == '\t') {
                    continue;
                }
            }
            sb.append(c);
            if (c == '"' && !escaped) {
                skip = !skip;
            }
        }
        return sb.toString().replaceAll("\r\n", "\\\\r\\\\n");
    }
}
