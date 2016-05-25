/**
 * スルァイド用背景画像
 */
$('body').vegas({
  overlay: false,
  transition: 'burn',
  transitionDuration: 2000,
  delay: 10000,
  animation: 'random',
  animationDuration: 20000,
  slides: [
    { src: 'assets/images/001.jpg' },
    { src: 'assets/images/002.jpg' },
    { src: 'assets/images/003.jpg' },
  ]
});