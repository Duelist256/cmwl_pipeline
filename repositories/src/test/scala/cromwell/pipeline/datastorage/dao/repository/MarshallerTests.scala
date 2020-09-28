package cromwell.pipeline.datastorage.dao.repository

import cromwell.pipeline.datastorage.dto.user.{PasswordUpdateRequest, UserUpdateRequest}
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import play.api.libs.json.{JsError, JsSuccess}

object MarshallerTests extends Properties("marshaller") {
  import utils.ArbitraryUtils._
  import utils.FormatUtils._

  property("userUpdateRequest") = forAll { (a: UserUpdateRequest) =>
    userUpdateRequestFormat.reads(userUpdateRequestFormat.writes(a)) match {
      case JsSuccess(value, _) => value == a
      case JsError(_)          => false
    }
  }

  property("passwordUpdateRequest") = forAll { (a: PasswordUpdateRequest) =>
    passwordUpdateRequestFormat.reads(passwordUpdateRequestFormat.writes(a)) match {
      case JsSuccess(value, _) => value == a
      case JsError(_)          => false
    }
  }
}
