package WebRequest;

import Objects.Product;
import Objects.ProductList;
import Objects.Rating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Request {
    private URL url;
    private HttpURLConnection connection;
    private Reader streamReader;
    private StringBuffer content;

    public Request()
    {
        url = null;
        connection = null;
        streamReader = null;
        content = new StringBuffer();

        try {
            url = new URL("https://fakestoreapi.com/products/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void getData()
    {
        int status = 0;
        String inputLine;

        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }

        try {
            status = connection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (status > 299) {
            streamReader = new InputStreamReader(connection.getErrorStream());
        } else {
            try {
                streamReader = new InputStreamReader(connection.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            BufferedReader in = new BufferedReader(streamReader);


            while (true) {
                try {
                    if ((inputLine = in.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                content.append(inputLine);
            }

            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void WriteDataInMemory(String path, String fileFormat)
    {

    }

    public void generateProductList(ProductList products)
    {
        try {
            String[] obiecte = content.substring(1, content.length() - 1).split("\\},\\{");

            for (String obiect : obiecte) {
                obiect = "{" + obiect + "}";

                int id = Integer.parseInt(extractValue(obiect, "\"id\""));
                String title = extractValue(obiect, "\"title\"");
                double price = Double.parseDouble(extractValue(obiect, "\"price\""));
                String description = extractValue(obiect, "\"description\"");
                String category = extractValue(obiect, "\"category\"");
                String image = extractValue(obiect, "\"image\"");

                products.addProduct(new Product(id,price, title, description, category, image, "$", new Rating(0,0, 0)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String extractValue(String jsonString, String key) {
        int keyIndex = jsonString.indexOf(key);

        if (keyIndex == -1) {
            return null;
        }

        int valueStartIndex = jsonString.indexOf(":", keyIndex) + 1;
        int valueEndIndex = jsonString.indexOf(",\"", valueStartIndex);

        if (valueEndIndex == -1) {
            valueEndIndex = jsonString.indexOf("}", valueStartIndex);
        }

        String value = jsonString.substring(valueStartIndex, valueEndIndex).trim();

        if (value.startsWith("\"") && value.endsWith("\"")) {
            value = value.substring(1, value.length() - 1);
        }

        return value;
    }
}
