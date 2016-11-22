package com.interview.utils;

public class Constants {

	public static final String DEFAULT_TIME_ZONE = "Asia/Kolkata";

	public static final String HEALTH_OK = "Health is good";

	public enum API_STATUS {
		SUCCESS("success"), FAILURE("failure");

		private String status;

		private API_STATUS(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}
	}

	public enum FILTER_TYPE {
		STORES("nearby_stores"), DELIVERY_TIME("delivery_time");

		private String value;

		private FILTER_TYPE(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum INDICES {

		MAIN_FILTERS_INDEX("filters_version_2", "styles", "filters"), TEMP_FILTERS_INDEX("filters_temp", "styles",
				"filters"), TEST_IMS_INDEX("filters_temp", "styles", "kiran"), MAIN_SEARCH_INDEX("search_version_2",
						"styles", "search"), TEMP_SEARCH_INDEX("search_temp", "styles", "search"), MAIN_LOCATIONS_INDEX(
								"locations_version_2", "pincodes", "locations"), TEMP_LOCATIONS_INDEX("locations_temp",
										"pincodes", "locations"), MAIN_FCM_INDEX("fcm_version_2", "stores",
												"fcm"), TEMP_FCM_INDEX("fcm_temp", "stores", "fcm"), MAIN_LMS_INDEX(
														"lms_version_2", "couriers", "lms"), TEMP_LMS_INDEX("lms_temp",
																"couriers", "lms"), SERVICEABILITY_COURIER(
																		"serviceability_version_1", "couriers",
																		"serviceability"), SERVICEABILITY_FULFILLMENTCENTER(
																				"serviceability_version_1",
																				"fulfillmentCenters",
																				"serviceability"), SERVICEABILITY_PAYMENTSERVICECOURIER(
																						"serviceability_version_1",
																						"paymentServiceCouriers",
																						"serviceability"), LMS_NEW(
																								"lms_version_1",
																								"serviceability",
																								"lms_new"), PINCODE_DELIVERY_INDEX(
																										"delivery_index",
																										"pincode",
																										"delivery");

		private String indexName;
		private String typeName;
		private String aliasName;

		INDICES(String indexName, String typeName, String aliasName) {
			this.indexName = indexName;
			this.typeName = typeName;
			this.aliasName = aliasName;
		}

		public String getIndexName() {
			return this.indexName;
		}

		public String getTypeName() {
			return this.typeName;
		}

		public String getAliasName() {
			return this.aliasName;
		}
	}

	public enum MODULE {
		ODIN("odin"), SOM("som");

		private String value;

		private MODULE(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum STYLE_AVAILABILITY {
		UNIVERSE("Universe"), IN_STORE("In Store"), NOT_IN_STORE("Not In Store");

		private String value;

		private STYLE_AVAILABILITY(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum REINDEX_STATUS {
		IN_PROGRESS, INDEX_CREATION_SUCCESS, INDEX_CREATION_FAILED, DATA_MIGRATION_SUCCESS, DATA_MIGRATION_FAILED, ALIAS_ADDITION_SUCCESS, ALIAS_ADDITION_FAILED, ALIAS_REMOVAL_SUCCESS, ALIAS_REMOVAL_FAILED, REINDEX_SUCESS, INDEX_REMOVAL_SUCCESS, INDEX_REMOVAL_FAILED;
	}

	public enum API_REQUEST_STATUS {
		RECEIVED, PUSHED_QUEUE, CONSUMED_QUEUE, STARTED_PROCESSING, PROCESSED, ERRORED;
	}

	public enum LMS_UPDATE_METHODS {
		LMS_COURIER_MAX_VALUE, LMS_COURIER_TAT_COST, LMS_COURIER_CUT_OFF, LMS_FPS_ENABLE, LMS_COURIER_PRIORITY_SERVICE_CLUSTER, LMS_COURIER_PRIORITY_SERVICE, LMS_ADD_COURIER, LMS_DELETE_FC;
	}

	public enum PUSH_TYPE {
		PINCODE_DELIVERY_PUSH
	}

	public enum FILTER_LEVEL {
		STYLE("style"), SKU("sku"), FC("fc");

		private String value;

		private FILTER_LEVEL(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum LMS_SERVICE_TYPE {
		SDD("sdd"), NDD("ndd"), STANDARD("standard");

		private String value;

		private LMS_SERVICE_TYPE(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum DELIVERY_OPTION {
		TODAY("today"), TOMORROW("tomorrow"), IN_A_WEEK("one_week");

		private String value;

		private DELIVERY_OPTION(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum DATE_TIME_FORMAT {
		YYYY_MM_DD("yyyy-MM-dd"), YYYY_MM_DD_HH_MM("yyyy-MM-dd HHmm"), HHMM("HHmm");

		private String value;

		private DATE_TIME_FORMAT(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum PRODUCT_LISTING_SORT_OPTION {
		POPULARITY("popularity"), NEWEST("newest"), PRICE_LOW_TO_HIGH("price_low_to_high"), PRICE_HIGH_TO_LOW(
				"price_high_to_low"), RELEVANCE("relevance");

		private String value;

		private PRODUCT_LISTING_SORT_OPTION(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum STYLE_DOCUMENT_FIELD_PATH {
		STYLE_ID("styleId"), STATUS("status"), PCM_ARTICLE_TYPE("pcmArticleType"), PRICE("price"), ON_SALE(
				"onSale"), CREATED_TIME("createdTime"), DATA_COMPLETE("dataComplete"), SKU("skus"), SKU_QUANTITY(
						"skus.quantity"), SKU_PRICE("skus.grossSP"), FC_IDS_WITH_INVENTORY("fcsWithInventory"), FC(
								"skus.fcinventorys"), FC_ID("skus.fcinventorys.fcId"), FC_QUANTITY(
										"skus.fcinventorys.quantity"), FC_ACTUAL_QUANTITY(
												"skus.fcinventorys.actualQty");

		private String value;

		private STYLE_DOCUMENT_FIELD_PATH(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

}