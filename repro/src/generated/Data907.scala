package generated

final case class Data907(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data907 = copy(name = name.toUpperCase)
  def scale(k: Double): Data907 = copy(value = value * k)
  def addTag(t: String): Data907 = copy(tags = t :: tags)
  def put(k: String, v: String): Data907 = copy(meta = meta.updated(k, v))
  def merge(other: Data907): Data907 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data907 {
  given Ordering[Data907] = Ordering.by(_.id)
  def empty: Data907 = Data907(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data907 =
    Data907(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data907] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
