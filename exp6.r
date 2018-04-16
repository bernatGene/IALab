par(mfrow=c(1,2))

tiempo_ejec_mas_centros <- c(11307, 11303, 12729, 14193, 15586)
tiempo_ejec_mas_helis <- c(9960, 10918, 12047, 12096, 12429)

y_range <- range(9, 16)
plot(tiempo_ejec_mas_centros/1000, type="o", col="blue", ylim=y_range, 
     axes=FALSE, ann=FALSE)
axis(1, at=1:5, lab=c("5", "10", "15", "20", "25"))
axis(2, las=1, at=1*0:y_range[2])
box()
lines(tiempo_ejec_mas_helis/1000, type="o", pch=22, lty=2, col="red")
title(main="Tiempo de ejecución", font.main=4)
grid(col="gray")
title(xlab="Helicopteros", col.lab=rgb(0,0.5,0))
title(ylab="Tiempo (s)", col.lab=rgb(0,0.5,0))

legend(1, y_range[2], c("Mas centros","Mas Helicopteros/Centro"), cex=0.8, 
       col=c("blue","red"), pch=21:22, lty=1:2);


sol_mas_centros <- c(3695, 3307, 3154, 3082, 3044)
sol_mas_helis <- c(3695, 3660, 3634, 3637, 3657)

y_range <- range(3000, 4000)
plot(sol_mas_centros, type="o", col="blue", ylim=y_range, 
     axes=FALSE, ann=FALSE)
axis(1, at=1:5, lab=c("5", "10", "15", "20", "25"))
axis(2, las=1, at=100*0:y_range[2])
box()
lines(sol_mas_helis, type="o", pch=22, lty=2, col="red")
title(main="Calidad de la solución", font.main=4)
grid(col="gray")
title(xlab="Helicopteros", col.lab=rgb(0,0.5,0))
title(ylab="Tiempo (ms)", col.lab=rgb(0,0.5,0))

legend(1, y_range[2], c("Mas centros","Mas Helicopteros/Centro"), cex=0.8, 
       col=c("blue","red"), pch=21:22, lty=1:2);