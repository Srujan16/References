1) maven plugin descriptor issues in 3.0 version

https://books.sonatype.com/mvnref-book/reference/writing-plugins-sect-mojo-params.html


Concepts:
	
	Loading resources into jar
	reading resources from jar in another project which uses the jar
	classLoader




 /*   private void copy(String source, String destination) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            InputStream inputStream = getInputStream(source);
            bufferedReader = getBufferedReader(inputStream);
            File outputFile = getFile(destination);
            bufferedWriter = getBufferedWriter(bufferedWriter, outputFile);
            FileCopyUtils.copy(bufferedReader, bufferedWriter);
            if (destination.equals("pom.xml")) {
                updatePom(outputFile);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not founf",e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create new File", e);
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

 */


    /*private BufferedWriter getBufferedWriter(BufferedWriter bufferedWriter, File outputFile) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
        return bufferedWriter;
    }

    private BufferedReader getBufferedReader(InputStream inputStream) {
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedReader;
    }

    private InputStream getInputStream(String source) {
        return getClass().getClassLoader().getResourceAsStream(source);
    }
*/

