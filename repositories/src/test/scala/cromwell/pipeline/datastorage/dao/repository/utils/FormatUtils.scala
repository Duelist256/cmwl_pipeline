package cromwell.pipeline.datastorage.dao.repository.utils

import cromwell.pipeline.datastorage.dto.user.{PasswordUpdateRequest, UserUpdateRequest}
import play.api.libs.json.{Format, Json}

object FormatUtils {
  implicit val userUpdateRequestFormat: Format[UserUpdateRequest] = Json.format[UserUpdateRequest]
  implicit val passwordUpdateRequestFormat: Format[PasswordUpdateRequest] = Json.format[PasswordUpdateRequest]
}
