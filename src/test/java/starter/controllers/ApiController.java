package starter.controllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class ApiController {

    public String getlastEmailId(WebDriver driver) {
        try {
            String verificationCode = "";
            String baseURL = "https://mailtrap.io/api/v1/inboxes/1870076";
            String apiToken = "7d6cfc938aa62249a8c95e32c4845846";

            ResponseBody responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
            String lastEmailId = String.valueOf(responseBodyInbox.jsonPath().getList("id").get(0));

            return lastEmailId;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getEmailVerificationCode(WebDriver driver) {
        try {
            String verificationCode = "";
            String baseURL = "https://mailtrap.io/api/v1/inboxes/1870076";
            String apiToken = "7d6cfc938aa62249a8c95e32c4845846";

            ResponseBody responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
            String lastEmailId = String.valueOf(responseBodyInbox.jsonPath().getList("id").get(0));
            ResponseBody responseBodyMail = getMethod_ResponseBody(String.format("%s/messages/%s/body.html", baseURL, lastEmailId), apiToken);
            String responseBodyMailString = String.valueOf(responseBodyMail.asString());

            verificationCode = responseBodyMailString.substring(responseBodyMailString.indexOf("code is <b>") + 11, responseBodyMailString.lastIndexOf("</b>, it will expire in 5 minutes")); //Todo simplify

            return verificationCode;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getEmailAuthorizationCode(WebDriver driver, String currentEmailId) {
        try {
            String verificationCode = "";
            String baseURL = "https://mailtrap.io/api/v1/inboxes/1870076";
            String apiToken = "7d6cfc938aa62249a8c95e32c4845846";
            int count = 0;

            ResponseBody responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
            String lastEmailId = String.valueOf(responseBodyInbox.jsonPath().getList("id").get(0));
            System.out.println("lastEmailId = " + lastEmailId);
            System.out.println("currentEmailId = " + currentEmailId);
            while (lastEmailId.equalsIgnoreCase(currentEmailId) & count < 12) {
                count++;
                Thread.sleep(5000);
                responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
                lastEmailId = String.valueOf(responseBodyInbox.jsonPath().getList("id").get(0));
                System.out.println("lastEmailId = " + lastEmailId);
                System.out.println("currentEmailId = " + currentEmailId);
            }

            if (lastEmailId.equalsIgnoreCase(currentEmailId)) {
                return "000000"; // No found last email
            }

            ResponseBody responseBodyMail = getMethod_ResponseBody(String.format("%s/messages/%s/body.html", baseURL, lastEmailId), apiToken);
            String responseBodyMailString = String.valueOf(responseBodyMail.asString());

            verificationCode = (responseBodyMailString.substring(responseBodyMailString.indexOf("<span") + 11, responseBodyMailString.lastIndexOf("</span")).split("\n"))[1].replaceAll(" ", "");
            System.out.println("verificationCode = " + verificationCode);
            return verificationCode;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getURL(WebDriver driver) {
        try {
            int count = 0;
            String urlToGo, urlToGoSplited = " ";
            String baseURL = "https://mailtrap.io/api/v1/inboxes/1870076";
            String apiToken = "7d6cfc938aa62249a8c95e32c4845846";
            ResponseBody responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
            String lastSubject = String.valueOf(responseBodyInbox.jsonPath().getList("subject").get(0));
/*            if (!lastSubject.equalsIgnoreCase("Create New Appmoto Password")){
                Thread.sleep(59000); //Todo wait for next email
                responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
                lastSubject = String.valueOf(responseBodyInbox.jsonPath().getList("subject").get(0));
            }*/
            while (!lastSubject.equalsIgnoreCase("Create New Appmoto Password") & count < 8) {
                count += 1;
                Thread.sleep(20000);
                responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
                lastSubject = String.valueOf(responseBodyInbox.jsonPath().getList("subject").get(0));
                System.out.println("lastSubject = " + lastSubject);
            }

            if (lastSubject.equalsIgnoreCase("Create New Appmoto Password")) {
                String lastEmailId = String.valueOf(responseBodyInbox.jsonPath().getList("id").get(0));
                ResponseBody responseBodyMail = getMethod_ResponseBody(String.format("%s/messages/%s/body.html", baseURL, lastEmailId), apiToken);
                String responseBodyMailString = String.valueOf(responseBodyMail.asString());
                urlToGoSplited = responseBodyMailString.split("href=\"")[1];
                urlToGo = urlToGoSplited.split("\" target")[0];
                return urlToGo;
            } else {
                try {
                    throw new io.cucumber.java.PendingException();
                } catch (Exception e) {
                    Assert.assertTrue("Last Email is taking so long!!, Check Spam folder!", false);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the URL from the Mail Serve", false);

        }
        return "";
    }

    public String getRecoveryPasswordURL(WebDriver driver) {
        try {
            int count = 0;
            String urlToGo, urlToGoSplited = " ";
            String baseURL = "https://mailtrap.io/api/v1/inboxes/1870076";
            String apiToken = "7d6cfc938aa62249a8c95e32c4845846";
            ResponseBody responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
            String lastSubject = String.valueOf(responseBodyInbox.jsonPath().getList("subject").get(0));

            while (!lastSubject.equalsIgnoreCase("Recover your password") & count < 8) {
                count += 1;
                Thread.sleep(20000);
                responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
                lastSubject = String.valueOf(responseBodyInbox.jsonPath().getList("subject").get(0));
                System.out.println("lastSubject = " + lastSubject);
            }

            if (lastSubject.equalsIgnoreCase("Recover your password")) {
                String lastEmailId = String.valueOf(responseBodyInbox.jsonPath().getList("id").get(0));
                ResponseBody responseBodyMail = getMethod_ResponseBody(String.format("%s/messages/%s/body.html", baseURL, lastEmailId), apiToken);
                String responseBodyMailString = String.valueOf(responseBodyMail.asString());
                urlToGoSplited = responseBodyMailString.substring(responseBodyMailString.indexOf("href=") + "href=".length()).split(" ")[0];
                urlToGo = urlToGoSplited;
                return urlToGo;
            } else {
                try {
                    throw new io.cucumber.java.PendingException();
                } catch (Exception e) {
                    Assert.assertTrue("Last Email is taking so long!!, Check Spam folder!", false);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the URL from the Mail Serve", false);

        }
        return "";
    }

    public String getOTTOInsureURL(WebDriver driver) {
        try {
            int count = 0;
            String urlToGo, urlToGoSplited = " ";
            String baseURL = "https://mailtrap.io/api/v1/inboxes/1870076";
            String apiToken = "7d6cfc938aa62249a8c95e32c4845846";
            ResponseBody responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
            String lastSubject = String.valueOf(responseBodyInbox.jsonPath().getList("subject").get(0));

            while (!lastSubject.contains("New Application Of") & count < 8) {
                count += 1;
                Thread.sleep(20000);
                responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
                lastSubject = String.valueOf(responseBodyInbox.jsonPath().getList("subject").get(0));
                System.out.println("lastSubject = " + lastSubject);
            }

            if (lastSubject.contains("New Application Of")) {
                String lastEmailId = String.valueOf(responseBodyInbox.jsonPath().getList("id").get(0));
                ResponseBody responseBodyMail = getMethod_ResponseBody(String.format("%s/messages/%s/body.html", baseURL, lastEmailId), apiToken);
                String responseBodyMailString = String.valueOf(responseBodyMail.asString());
                urlToGo = responseBodyMailString.substring(responseBodyMailString.indexOf("href=")).split(" ")[0]; //responseBodyMailString.substring(responseBodyMailString.indexOf("href=")+"href=".length()).split(" ")[0]
                urlToGo = urlToGo.split("href=")[1];
                return urlToGo;
            } else {
                try {
                    throw new io.cucumber.java.PendingException();
                } catch (Exception e) {
                    Assert.assertTrue("Last Email is taking so long!!, Check Spam folder!", false);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the URL from the Mail Serve", false);

        }
        return "";
    }

    public String getEmailVerificationCode2(WebDriver driver) {
        try {
            String verificationCode = "";
            String baseURL = "https://mailtrap.io/api/v1/inboxes/1870076";
            String apiToken = "7d6cfc938aa62249a8c95e32c4845846";
            Thread.sleep(20000);// Wait for the next email
            ResponseBody responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
            String lastSubject = String.valueOf(responseBodyInbox.jsonPath().getList("subject").get(0));
            if (!lastSubject.equalsIgnoreCase("Validation Code")) {
                Thread.sleep(59000); //Todo wait for next email

                responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
                lastSubject = String.valueOf(responseBodyInbox.jsonPath().getList("subject").get(0));
            }

            if (lastSubject.equalsIgnoreCase("Validation Code")) {
                String lastEmailId = String.valueOf(responseBodyInbox.jsonPath().getList("id").get(0));
                ResponseBody responseBodyMail = getMethod_ResponseBody(String.format("%s/messages/%s/body.html", baseURL, lastEmailId), apiToken);
                String responseBodyMailString = String.valueOf(responseBodyMail.asString());

                verificationCode = responseBodyMailString.substring(responseBodyMailString.indexOf("pointer;\">") + 10, responseBodyMailString.lastIndexOf("</span>")).replaceAll(" ", "").replaceAll("\n", ""); // Todo refactor this

            } else {
                try {
                    throw new io.cucumber.java.PendingException();
                } catch (Exception e) {
                    System.out.println("Last Email is taking so long!!, Check Spam folder!"); // Todo implemente with serenity report
                    //Assert.assertTrue("Email already exist !!", false);
                }
            }

            return verificationCode;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getEmailNewApplicationLink(WebDriver driver) {
        try {
            String urlToGo, urlToGoSplited = " ";
            String baseURL = "https://mailtrap.io/api/v1/inboxes/1870076";
            String apiToken = "7d6cfc938aa62249a8c95e32c4845846";
            ResponseBody responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
            String lastSubject = String.valueOf(responseBodyInbox.jsonPath().getList("subject").get(0));
            if (!lastSubject.contains("You are a few steps away from buying from")) {
                Thread.sleep(59000); //Todo wait for next email
                System.out.println("lastSubject = " + lastSubject);
            }
            if (lastSubject.contains("You are a few steps away from buying from")) {
                String lastEmailId = String.valueOf(responseBodyInbox.jsonPath().getList("id").get(0));
                ResponseBody responseBodyMail = getMethod_ResponseBody(String.format("%s/messages/%s/body.html", baseURL, lastEmailId), apiToken);
                String responseBodyMailString = String.valueOf(responseBodyMail.asString());
                urlToGoSplited = responseBodyMailString.split("href=")[1];
                urlToGo = urlToGoSplited.split("target=\"_blank\"")[0].replaceAll(" ", "").replaceAll("\n", ""); //Todo refactory it
                return urlToGo;
            } else {
                try {
                    throw new io.cucumber.java.PendingException();
                } catch (Exception e) {
                    System.out.println("Last Email is taking so long!!, Check Spam folder!"); // Todo implemente with serenity report
                    //Assert.assertTrue("Email already exist !!", false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the URL from the Mail Serve", false);

        }
        return "";
    }

    public String getEmailNewApplicationLink2(WebDriver driver) {
        try {
            String urlToGo, urlToGoSplited = " ";
            String baseURL = "https://mailtrap.io/api/v1/inboxes/1870076";
            String apiToken = "7d6cfc938aa62249a8c95e32c4845846";
            ResponseBody responseBodyInbox = getMethod_ResponseBody(String.format("%s/messages?page=1&last_id", baseURL), apiToken);
            String lastSubject = String.valueOf(responseBodyInbox.jsonPath().getList("subject").get(0));
            if (!lastSubject.contains("New Appmoto application")) {
                Thread.sleep(59000); //Todo wait for next email
                System.out.println("lastSubject = " + lastSubject);
            }
            if (lastSubject.contains("New Appmoto application")) {
                String lastEmailId = String.valueOf(responseBodyInbox.jsonPath().getList("id").get(0));
                ResponseBody responseBodyMail = getMethod_ResponseBody(String.format("%s/messages/%s/body.html", baseURL, lastEmailId), apiToken);
                String responseBodyMailString = String.valueOf(responseBodyMail.asString());
                urlToGoSplited = responseBodyMailString.split("href=")[1];
                urlToGo = urlToGoSplited.split("target=\"_blank\"")[0].replaceAll(" ", "").replaceAll("\n", ""); //Todo refactory it
                return urlToGo;
            } else {
                try {
                    throw new io.cucumber.java.PendingException();
                } catch (Exception e) {
                    System.out.println("Last Email is taking so long!!, Check Spam folder!"); // Todo implemente with serenity report
                    //Assert.assertTrue("Email already exist !!", false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue("Error getting the URL from the Mail Serve", false);

        }
        return "";
    }

    public ResponseBody getMethod_ResponseBody(String baseURI, String apiToken) {
        RestAssured.baseURI = baseURI;
        RequestSpecification request = RestAssured.given();
        request.header("Api-Token", apiToken);
        Response response = request.get();
        return response.body();
    }
}
