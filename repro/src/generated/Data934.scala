package generated

final case class Data934(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data934 = copy(name = name.toUpperCase)
  def scale(k: Double): Data934 = copy(value = value * k)
  def addTag(t: String): Data934 = copy(tags = t :: tags)
  def put(k: String, v: String): Data934 = copy(meta = meta.updated(k, v))
  def merge(other: Data934): Data934 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data934 {
  given Ordering[Data934] = Ordering.by(_.id)
  def empty: Data934 = Data934(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data934 =
    Data934(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data934] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
