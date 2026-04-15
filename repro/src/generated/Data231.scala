package generated

final case class Data231(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data231 = copy(name = name.toUpperCase)
  def scale(k: Double): Data231 = copy(value = value * k)
  def addTag(t: String): Data231 = copy(tags = t :: tags)
  def put(k: String, v: String): Data231 = copy(meta = meta.updated(k, v))
  def merge(other: Data231): Data231 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data231 {
  given Ordering[Data231] = Ordering.by(_.id)
  def empty: Data231 = Data231(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data231 =
    Data231(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data231] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
