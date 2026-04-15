package generated

final case class Data822(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data822 = copy(name = name.toUpperCase)
  def scale(k: Double): Data822 = copy(value = value * k)
  def addTag(t: String): Data822 = copy(tags = t :: tags)
  def put(k: String, v: String): Data822 = copy(meta = meta.updated(k, v))
  def merge(other: Data822): Data822 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data822 {
  given Ordering[Data822] = Ordering.by(_.id)
  def empty: Data822 = Data822(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data822 =
    Data822(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data822] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
