package com.iprd.intent_proto

enum class ResponseStatus(val responseText : String,val responseCode:Int) {
  SUCCESS("Success",0),
  OPEN_CAMP_LINK_NOT_FOUND("Open camp link id not found in local DB",1),
  MEMBER_ID_NOT_FOUND("Open camp link member id not found or duplicate",2),
  INPUT_JSON_INVALID("Invalid input json provided",3),
  QR_INVALID("Qr Scanned is invalid", 4),
  PERMISSION_NOT_GRANTED("Permission not granted", 5),
}