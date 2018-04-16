par(mfrow=c(1,2))

a <- c(2132,21497,118634,590732)
barplot(a/1000, xlab = "Valor de k",
        main="Hill Climbing",
        ylab = "Tiempo (s)",
        ylim=c(0,600),
        names.arg = c("1", "2", "3", "4"),
        col="skyblue")

b <- c(403,616,1036,1280,1630,1927,2371,2662,3025,3259,3581,4059,4427,4690,5579,5528,5938,6365,6505,7221,7725,8454,8179,8614,9604)
barplot(b/1000, xlab = "Valor de k",
        main="Simulated Annealing",
        ylab = "Tiempo (s)",
        ylim=c(0,10),
        names.arg = c("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23","24", "25"),
        col="skyblue")
