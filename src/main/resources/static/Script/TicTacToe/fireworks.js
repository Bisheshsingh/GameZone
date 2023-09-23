const sleep = ms => new Promise(r => setTimeout(r, ms));
const canvas = document.getElementById("fireworksCanvas");
const ctx = canvas.getContext("2d");

canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

class Firework {
    constructor(x, y, color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.particles = [];
        for (let i = 0; i < 50; i++) {
            const speed = Math.random() * 4 + 2;
            const angle = Math.PI * 2 * Math.random();
            this.particles.push({
                x: this.x,
                y: this.y,
                vx: Math.cos(angle) * speed,
                vy: Math.sin(angle) * speed,
                alpha: 1
            });
        }
    }

    draw() {
        this.particles.forEach(particle => {
            ctx.fillStyle = `rgba(${this.color},${particle.alpha})`;
            ctx.fillRect(particle.x, particle.y, 3, 3);
            particle.x += particle.vx;
            particle.y += particle.vy;
            particle.alpha -= 0.02;
        });
        this.particles = this.particles.filter(particle => particle.alpha > 0);
    }
}

const fireworks = [];

async function startFireworks() {
    for(let i=0;i<=100;i++) {
        const color = [
            Math.floor(Math.random() * 256),
            Math.floor(Math.random() * 256),
            Math.floor(Math.random() * 256)
        ];
        let firework = new Firework(Math.random() * canvas.width,
            Math.random() * canvas.height, color);
        fireworks.push(firework);
        await sleep(500);
    }
}

function animate() {
    ctx.fillStyle = "rgba(0,0,0,0.1)";
    ctx.fillRect(0, 0, canvas.width, canvas.height);
    fireworks.forEach((firework, index) => {
        firework.draw();
        if (firework.particles.length === 0) {
            fireworks.splice(index, 1);
        }
    });
    requestAnimationFrame(animate);
}

animate();
startFireworks();