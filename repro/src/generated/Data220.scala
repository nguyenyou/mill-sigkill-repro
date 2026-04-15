package generated

final case class Data220(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data220 = copy(name = name.toUpperCase)
  def scale(k: Double): Data220 = copy(value = value * k)
  def addTag(t: String): Data220 = copy(tags = t :: tags)
  def put(k: String, v: String): Data220 = copy(meta = meta.updated(k, v))
  def merge(other: Data220): Data220 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data220 {
  given Ordering[Data220] = Ordering.by(_.id)
  def empty: Data220 = Data220(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data220 =
    Data220(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data220] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
