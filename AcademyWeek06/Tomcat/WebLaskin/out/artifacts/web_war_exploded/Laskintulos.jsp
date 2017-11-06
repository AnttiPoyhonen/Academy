<%

    if (request.getParameter("first") == null || "".equals(request.getParameter("first"))) return;

    double nr1, nr2, result;
    String nr1s, nr2s, type;

//    try {

        nr1 = Double.parseDouble(request.getParameter("first"));
        nr2 = Double.parseDouble(request.getParameter("second"));

//    } catch (NumberFormatException e) {
//
//        out.print("You did not enter valid numbers as input!");
//        return;
//
//    }

    type = request.getParameter("type");

    switch (type) {

        case "+":
            result = nr1 + nr2;
            break;
        case "-":
            result = nr1 - nr2;
            break;
        case "*":
            result = nr1 * nr2;
            break;
        case "div":
            if (nr2 == 0) {
                out.println("Cannot divide by zero! - ");
                result = 0;
                break;
            }
            result = nr1 / nr2;
            break;
        default:
            out.print("No proper calculation type selected! - ");
            result = 0;
            break;

    }

    out.print(result);

%>
