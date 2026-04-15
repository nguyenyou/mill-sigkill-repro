package generated

final case class Data744(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data744 = copy(name = name.toUpperCase)
  def scale(k: Double): Data744 = copy(value = value * k)
  def addTag(t: String): Data744 = copy(tags = t :: tags)
  def put(k: String, v: String): Data744 = copy(meta = meta.updated(k, v))
  def merge(other: Data744): Data744 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data744 {
  given Ordering[Data744] = Ordering.by(_.id)
  def empty: Data744 = Data744(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data744 =
    Data744(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data744] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
