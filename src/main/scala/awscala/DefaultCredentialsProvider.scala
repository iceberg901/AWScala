package awscala

class DefaultCredentialsProvider extends CredentialsProvider {
  private val provider = new com.amazonaws.auth.DefaultAWSCredentialsProviderChain
  override def getCredentials: Credentials = {
    val credentials = provider.getCredentials
    Credentials(credentials.getAWSAccessKeyId, credentials.getAWSSecretKey)
  }
  override def refresh: Unit = provider.refresh
}

object DefaultCredentialsProvider {
  def apply(): DefaultCredentialsProvider =
    new DefaultCredentialsProvider
}
