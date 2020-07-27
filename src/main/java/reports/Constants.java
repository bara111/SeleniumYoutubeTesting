package reports;

public class Constants {
    public static final String startHtmlPassedTest ="<!DOCTYPE html>" +
            "<html lang=\"en\" dir=\"ltr\">" +
            "<head>" +
            "<meta charset=\"utf-8\">" +
            "<title>Custom Report Main Page</title>" +
            "<link rel=\"stylesheet\" href=\"css/passed-page.css\">" +
            "</head>" +
            "<body>" +
            "<div class=\"top-section\">" +
            "<h1>Passed Tests</h1>" +
            "</div>" +
            "<div class=\"passed-test-section\">" +
            "<table>" +
            "<thead>" +
            "<tr>" +
            "<th>Parameter</th>" +
            "<th>Method Name</th>" +
            "<th>Time</th>" +
            "</tr>";
    public static final String startHtmlFailedTest ="<!DOCTYPE html>" +
            "<html lang=\"en\" dir=\"ltr\">" +
            "<head>" +
            "<meta charset=\"utf-8\">" +
            "<title>Custom Report Main Page</title>" +
            "<link rel=\"stylesheet\" href=\"css/failed-page.css\">" +
            "</head>" +
            "<body>" +
            "<div class=\"top-section\">" +
            "<h1>Failed Tests</h1>" +
            "</div>" +
            "<div class=\"passed-test-section\">" +
            "<table>" +
            "<thead>" +
            "<tr>" +
            "<th>Parameter</th>" +
            "<th>Method Name</th>" +
            "<th>Details</th>" +
            "<th>Time</th>" +
            "</tr>";
    public static final String startHtmlSkippedTest ="<!DOCTYPE html>" +
            "<html lang=\"en\" dir=\"ltr\">" +
            "<head>" +
            "<meta charset=\"utf-8\">" +
            "<title>Custom Report Main Page</title>" +
            "<link rel=\"stylesheet\" href=\"css/skipped-page.css\">" +
            "</head>" +
            "<body>" +
            "<div class=\"top-section\">" +
            "<h1>Skipped Tests</h1>" +
            "</div>" +
            "<div class=\"passed-test-section\">" +
            "<table>" +
            "<thead>" +
            "<tr>" +
            "<th>Parameter</th>" +
            "<th>Method Name</th>" +
            "<th>Time</th>" +
            "</tr>";
    public static final String endHtml=
            "</thead>"+
            "</table>"+
            "</div>"+
            "</body>"+
            "</html>";
}
