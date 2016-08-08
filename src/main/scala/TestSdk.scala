import com.fit2cloud.qingcloud.wsclient.QingCloudWSClient
import com.fit2cloud.qingcloud.wsclient.domain.model.QingCloudZone
import com.fit2cloud.qingcloud.wsclient.ui.model.CreateKeyPairRequest

/**
 * Created by bjcheny on 8/8/16.
 */
object TestSdk {
  def main(args: Array[String]): Unit = {
    val ACCESS_KEY_ID = ""
    val ACCESS_KEY_SECRET = ""
    val client = new QingCloudWSClient(ACCESS_KEY_ID, ACCESS_KEY_SECRET)

    val createKeyPairRequest = new CreateKeyPairRequest()
    val keypair_name = "test-sdk"
    val mode = "system"
    val encrypt_method = "ssh-rsa"

    createKeyPairRequest.setKeypair_name(keypair_name)
    createKeyPairRequest.setMode(mode)
    createKeyPairRequest.setEncrypt_method(encrypt_method)
    createKeyPairRequest.setZone(QingCloudZone.PEK2)

    val createKeyPairResponse = client.createKeyPair(createKeyPairRequest)
    val keypair_id = createKeyPairResponse.getKeypair_id()

    println("Successfully create KeyPair as " + keypair_id)
  }
}
