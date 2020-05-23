package org.omg.PortableInterceptor;


/**
* org/omg/PortableInterceptor/ClientRequestInterceptorOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u192/11897/corba/src/share/classes/org/omg/PortableInterceptor/Interceptors.idl
* Saturday, October 6, 2018 9:38:36 AM PDT
*/


/**
   * Client-side request interceptor.
   * <p>
   * A request Interceptor is designed to intercept the flow of a 
   * request/reply sequence through the ORB at specific points so that 
   * services can query the request information and manipulate the service 
   * contexts which are propagated between clients and servers. The primary 
   * use of request Interceptors is to enable ORB services to transfer 
   * context information between clients and servers. There are two types 
   * of request Interceptors: client-side and server-side. 
   * <p>
   * To write a client-side Interceptor, implement the 
   * <code>ClientRequestInterceptor</code> interface. 
   *
   * @see ClientRequestInfo
   */
public interface ClientRequestInterceptorOperations  extends org.omg.PortableInterceptor.InterceptorOperations
{

  /**
       * Allows an Interceptor to query request information and modify the 
       * service context before the request is sent to the server.
       * <p>
       * This interception point may throw a system exception. If it does, 
       * no other Interceptors' <code>send_request</code> operations are called. 
       * Those Interceptors on the Flow Stack are popped and their 
       * <code>receive_exception</code> interception points are called. This 
       * interception point may also throw a <code>ForwardRequest</code> 
       * exception. If an Interceptor throws this exception, no other 
       * Interceptors' <code>send_request</code> operations are 
       * called. Those Interceptors on the Flow Stack are popped and their 
       * <code>receive_other</code> interception points are called. 
       * <p>
       * Compliant Interceptors shall properly follow completion_status 
       * semantics if they throw a system exception from this interception 
       * point. The <code>completion_status</code> shall be 
       * <code>COMPLETED_NO</code>.
       *
       * @param ri Information about the current request being intercepted.
       * @exception ForwardRequest If thrown, indicates to the ORB that a
       *     retry of the request should occur with the new object given in
       *     the exception.
       */
  void send_request (org.omg.PortableInterceptor.ClientRequestInfo ri) throws org.omg.PortableInterceptor.ForwardRequest;

  /**
       * Allows an Interceptor to query information during a Time-Independent 
       * Invocation (TII) polling get reply sequence. 
       * <p>
       * With TII, an application may poll for a response to a request sent 
       * previously by the polling client or some other client. This poll is 
       * reported to Interceptors through the <code>send_poll</code> 
       * interception point and the response is returned through the 
       * <code>receive_reply</code> or <code>receive_exception</code> 
       * interception points.  If the response is not available before the
       * poll time-out expires, the system exception <code>TIMEOUT</code> is
       * thrown and <code>receive_exception</code> is called with this 
       * exception. 
       * <p>
       * This interception point may throw a system exception. If it does, 
       * no other Interceptors' <code>send_poll</code> operations are 
       * called. Those Interceptors on the Flow Stack are popped and their 
       * <code>receive_exception</code> interception points are called. 
       * <p>
       * Compliant Interceptors shall properly follow 
       * <code>completion_status</code> semantics if they throw a system 
       * exception from this interception point. The completion_status shall be 
       * <code>COMPLETED_NO</code>.
       * 
       * @param ri Information about the current request being intercepted.
       * @exception TIMEOUT thrown if the response is not available before 
       *     the poll time-out expires
       */
  void send_poll (org.omg.PortableInterceptor.ClientRequestInfo ri);

  /**
       * Allows an Interceptor to query the information on a reply after it 
       * is returned from the server and before control is returned to the 
       * client. 
       * <p>
       * This interception point may throw a system exception. If it does, 
       * no other Interceptors' <code>receive_reply</code> operations are 
       * called. The remaining Interceptors in the Flow Stack shall have 
       * their <code>receive_exception</code> interception point called. 
       * <p>
       * Compliant Interceptors shall properly follow 
       * <code>completion_status</code> semantics if they throw a system 
       * exception from this interception point. The 
       * <code>completion_status</code> shall be <code>COMPLETED_YES</code>.
       *
       * @param ri Information about the current request being intercepted.
       */
  void receive_reply (org.omg.PortableInterceptor.ClientRequestInfo ri);

  /**
       * Indicates to the interceptor that an exception occurred.  Allows
       * an Interceptor to query the exception's information before it is 
       * thrown to the client.
       * <p>
       * This interception point may throw a system exception. This has the 
       * effect of changing the exception which successive Interceptors 
       * popped from the Flow Stack receive on their calls to 
       * <code>receive_exception</code>. The exception thrown to the client 
       * will be the last exception thrown by an Interceptor, or the original 
       * exception if no Interceptor changes the exception. 
       * <p>
       * This interception point may also throw a <code>ForwardRequest</code> 
       * exception.  If an Interceptor throws this exception, no other 
       * Interceptors' <code>receive_exception</code> operations are called. 
       * The remaining Interceptors in the Flow Stack are popped and have their 
       * <code>receive_other</code> interception point called. 
       * <p>
       * If the <code>completion_status</code> of the exception is not 
       * <code>COMPLETED_NO</code>, then it is inappropriate for this 
       * interception point to throw a <code>ForwardRequest</code> exception. 
       * The request s at-most-once semantics would be lost. 
       * <p>
       * Compliant Interceptors shall properly follow 
       * <code>completion_status</code> semantics if they throw a system 
       * exception from this interception point. If the original exception is 
       * a system exception, the <code>completion_status</code> of the new 
       * exception shall be the same as on the original. If the original 
       * exception is a user exception, then the <code>completion_status</code> 
       * of the new exception shall be <code>COMPLETED_YES</code>. 
       * <p>
       * Under some conditions, depending on what policies are in effect, an 
       * exception (such as <code>COMM_FAILURE</code>) may result in a retry 
       * of the request. While this retry is a new request with respect to 
       * Interceptors, there is one point of correlation between the original 
       * request and the retry: because control has not returned to the 
       * client, the <code>PortableInterceptor.Current</code> for both the 
       * original request and the retrying request is the same.
       *
       * @param ri Information about the current request being intercepted.
       * @exception ForwardRequest If thrown, indicates to the ORB that a
       *     retry of the request should occur with the new object given in
       *     the exception.
       */
  void receive_exception (org.omg.PortableInterceptor.ClientRequestInfo ri) throws org.omg.PortableInterceptor.ForwardRequest;

  /**
       * Allows an Interceptor to query the information available when a 
       * request results in something other than a normal reply or an 
       * exception. For example, a request could result in a retry 
       * (e.g., a GIOP Reply with a <code>LOCATION_FORWARD</code> status was 
       * received); or on asynchronous calls, the reply does not immediately 
       * follow the request, but control shall return to the client and an 
       * ending interception point shall be called. 
       * <p>
       * For retries, depending on the policies in effect, a new request may or 
       * may not follow when a retry has been indicated. If a new request does 
       * follow, while this request is a new request, with respect to 
       * Interceptors, there is one point of correlation between the original 
       * request and the retry: because control has not returned to the client, 
       * the request scoped <code>PortableInterceptor.Current</code> for both 
       * the original request and the retrying request is the same.  
       * <p>
       * This interception point may throw a system exception. If it does, no 
       * other Interceptors' <code>receive_other</code> operations are called. 
       * The remaining Interceptors in the Flow Stack are popped and have 
       * their <code>receive_exception</code> interception point called.
       * <p>
       * This interception point may also throw a <code>ForwardRequest</code> 
       * exception.  If an Interceptor throws this exception, successive 
       * Interceptors' <code>receive_other</code> operations are called with 
       * the new information provided by the <code>ForwardRequest</code> 
       * exception. 
       * <p>
       * Compliant Interceptors shall properly follow 
       * <code>completion_status</code> semantics if they throw a system 
       * exception from this interception point. The 
       * <code>completion_status</code> shall be <code>COMPLETED_NO</code>. 
       * If the target invocation had completed, this interception point 
       * would not be called.
       * 
       * @param ri Information about the current request being intercepted.
       * @exception ForwardRequest If thrown, indicates to the ORB that a
       *     retry of the request should occur with the new object given in
       *     the exception.
       */
  void receive_other (org.omg.PortableInterceptor.ClientRequestInfo ri) throws org.omg.PortableInterceptor.ForwardRequest;
} // interface ClientRequestInterceptorOperations
