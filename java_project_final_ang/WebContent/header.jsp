

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@1,700&display=swap" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    <link rel='stylesheet' type='text/css' href='supp.css'>
</head>

<body>
    <div class="container-fluid">
        <div class="row bg-info sticky-top" style="height: 80px">
            <div class="col d-flex align-items-center text-light" style="font-family: 'Merriweather', serif;">

                <h3> Ticket Booking System</h1>
            </div>
            <div class="col d-flex justify-content-end align-items-center">
                <a class="btn btn-outline-light mr-1" style="font-family: 'Merriweather', serif;"><%= ((User)session.getAttribute("user")).getEmailId() %> </a>
                <a href="logout.htm" class="btn btn-outline-light mr-1 text-danger" style="font-family: 'Merriweather', serif;">Logut</a>
                <!-- <button class="btn btn-outline-light mr-1" (click)="">
                    Log Out
                </button> -->
            </div>
        </div>
    </div>
</body>
</html>