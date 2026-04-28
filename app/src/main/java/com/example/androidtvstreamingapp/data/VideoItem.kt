package com.example.androidtvstreamingapp.data

data class VideoItem(
    val id: String,
    val title: String,
    val description: String,
    val videoUrl: String,
    val thumbnailUrl: String,
    val category: String
)

val sampleVideos = listOf(
    // --- CATEGORY: ANIMATION ---
    VideoItem("1", "Big Buck Bunny", "Classic animation.", "https://www.w3schools.com/html/mov_bbb.mp4", "https://images.unsplash.com/photo-1470252649378-9c29740c9fa8?w=800&q=80", "Animation"),
    VideoItem("2", "Rabbit Test", "Smooth motion test.", "https://www.w3schools.com/jsref/movie.mp4", "https://images.unsplash.com/photo-1557050543-4d5f4e07ef46?w=800&q=80", "Animation"),
    VideoItem("3", "Space Journey", "CGI nebula trip.", "https://vjs.zencdn.net/v/oceans.mp4", "https://images.unsplash.com/photo-1446776811953-b23d57bd21aa?w=800&q=80", "Animation"),
    VideoItem("4", "Cartoon Clouds", "Stylized sky.", "https://www.w3schools.com/html/movie.mp4", "https://images.unsplash.com/photo-1483702721041-b23de737a886?w=800&q=80", "Animation"),
    VideoItem("5", "Glitch Art", "Abstract digital visuals.", "https://res.cloudinary.com/demo/video/upload/e_reverse/dog.mp4", "https://images.unsplash.com/photo-1550745165-9bc0b252726f?w=800&q=80", "Animation"),
    VideoItem("6", "Robot Dance", "Mechanized movement.", "https://vjs.zencdn.net/v/oceans.mp4", "https://images.unsplash.com/photo-1546776310-eef45dd6d63c?w=800&q=80", "Animation"),

    // --- CATEGORY: NATURE ---
    VideoItem("7", "Ocean Waves", "Deep blue sea.", "https://vjs.zencdn.net/v/oceans.mp4", "https://images.unsplash.com/photo-1505118380757-91f5f5632de0?w=800&q=80", "Nature"),
    VideoItem("8", "Waterfall", "Serene falls.", "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4", "https://images.unsplash.com/photo-1441974231531-c6227db76b6e?w=800&q=80", "Nature"),
    VideoItem("9", "Sea Turtle", "Reef swimming.", "https://res.cloudinary.com/demo/video/upload/v1631256434/sea_turtle.mp4", "https://images.unsplash.com/photo-1437622368342-7a3d73a34c8f?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c2VhJTIwdHVydGxlfGVufDB8fDB8fHww", "Nature"),
    VideoItem("10", "Jellyfish", "Bioluminescence.", "https://test-videos.co.uk/vids/jellyfish/mp4/h264/720/Jellyfish_720_10s_1MB.mp4", "https://images.unsplash.com/photo-1517404215738-15263e9f9178?w=800&q=80", "Nature"),
    VideoItem("11", "Green Forest", "Aerial forest view.", "https://www.w3schools.com/html/movie.mp4", "https://images.unsplash.com/photo-1721626830585-7250c537c44e?q=80&w=1332&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Nature"),
    VideoItem("12", "Mountain Peak", "Snowy summits.", "https://vjs.zencdn.net/v/oceans.mp4", "https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?w=800&q=80", "Nature"),
    VideoItem("13", "Star Trails", "Night sky lapse.", "https://res.cloudinary.com/demo/video/upload/e_reverse/dog.mp4", "https://content.instructables.com/FTE/CR8F/HMMF0QBL/FTECR8FHMMF0QBL.jpg?frame=true&width=1024&height=1024&fit=bounds", "Nature"),
    VideoItem("14", "Raindrops", "Close-up rain.", "https://www.w3schools.com/html/movie.mp4", "https://images.unsplash.com/photo-1515694346937-94d85e41e6f0?w=800&q=80", "Nature"),

    // --- CATEGORY: ACTION ---
    VideoItem("15", "City Lights", "Urban traffic.", "https://www.w3schools.com/html/movie.mp4", "https://images.unsplash.com/photo-1449824913935-59a10b8d2000?w=800&q=80", "Action"),
    VideoItem("16", "Cinematic Cuts", "Quick action clips.", "https://res.cloudinary.com/demo/video/upload/e_reverse/dog.mp4", "https://images.unsplash.com/photo-1485846234645-a62644f84728?w=800&q=80", "Action"),
    VideoItem("17", "Surfing Giant", "Big wave action.", "https://vjs.zencdn.net/v/oceans.mp4", "https://images.unsplash.com/photo-1502680390469-be75c86b636f?w=800&q=80", "Action"),
    VideoItem("18", "Drift Race", "Fast car movement.", "https://www.w3schools.com/html/mov_bbb.mp4", "https://images.unsplash.com/photo-1503376780353-7e6692767b70?w=800&q=80", "Action"),
    VideoItem("19", "Skateboarding", "Trick montage.", "https://res.cloudinary.com/demo/video/upload/v1631256434/sea_turtle.mp4", "https://images.unsplash.com/photo-1517404215738-15263e9f9178?q=80&w=500", "Action"),
    VideoItem("20", "Snowboard Air", "Winter sports.", "https://vjs.zencdn.net/v/oceans.mp4", "https://images.unsplash.com/photo-1441974231531-c6227db76b6e?q=80&w=500", "Action"),

    // --- CATEGORY: TECH ---
    VideoItem("21", "Code Matrix", "Scrolling binary.", "https://www.w3schools.com/html/movie.mp4", "https://images.unsplash.com/photo-1587620962725-abab7fe55159?w=800&q=80", "Tech"),
    VideoItem("22", "Circuit Board", "Macro hardware.", "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4", "https://images.unsplash.com/photo-1518770660439-4636190af475?w=800&q=80", "Tech"),
    VideoItem("23", "Data Nodes", "Network connectivity.", "https://test-videos.co.uk/vids/jellyfish/mp4/h264/720/Jellyfish_720_10s_1MB.mp4", "https://images.unsplash.com/photo-1451187580459-43490279c0fa?w=800&q=80", "Tech"),
    VideoItem("24", "Cyber City", "Neon urbanism.", "https://www.w3schools.com/html/movie.mp4", "https://images.unsplash.com/photo-1519389950473-47ba0277781c?w=800&q=80", "Tech"),
    VideoItem("25", "AI Engine", "Neural net render.", "https://www.w3schools.com/html/movie.mp4", "https://images.unsplash.com/photo-1677442136019-21780ecad995?w=800&q=80", "Tech"),

    // --- CATEGORY: TRAVEL ---
    VideoItem("26", "Paris Streets", "Evening walk.", "https://vjs.zencdn.net/v/oceans.mp4", "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?w=800&q=80", "Travel"),
    VideoItem("27", "Tokyo Neon", "Nighttime vibe.", "https://test-videos.co.uk/vids/jellyfish/mp4/h264/720/Jellyfish_720_10s_1MB.mp4", "https://images.unsplash.com/photo-1540959733332-eab4deabeeaf?w=800&q=80", "Travel"),
    VideoItem("28", "Desert Dunes", "Golden sands.", "https://res.cloudinary.com/demo/video/upload/v1631256434/sea_turtle.mp4", "https://images.unsplash.com/photo-1473580044384-7ba9967e16a0?w=800&q=80", "Travel"),
    VideoItem("29", "Swiss Alps", "Mountain train.", "https://www.w3schools.com/html/movie.mp4", "https://images.unsplash.com/photo-1531310197839-ccf54634509e?w=800&q=80", "Travel"),
    VideoItem("30", "Beach Sunset", "Tropical end of day.", "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4", "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=800&q=80", "Travel")
)
