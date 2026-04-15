package generated

final case class Data558(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data558 = copy(name = name.toUpperCase)
  def scale(k: Double): Data558 = copy(value = value * k)
  def addTag(t: String): Data558 = copy(tags = t :: tags)
  def put(k: String, v: String): Data558 = copy(meta = meta.updated(k, v))
  def merge(other: Data558): Data558 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data558 {
  given Ordering[Data558] = Ordering.by(_.id)
  def empty: Data558 = Data558(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data558 =
    Data558(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data558] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
