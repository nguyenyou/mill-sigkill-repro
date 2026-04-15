package generated

final case class Data229(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data229 = copy(name = name.toUpperCase)
  def scale(k: Double): Data229 = copy(value = value * k)
  def addTag(t: String): Data229 = copy(tags = t :: tags)
  def put(k: String, v: String): Data229 = copy(meta = meta.updated(k, v))
  def merge(other: Data229): Data229 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data229 {
  given Ordering[Data229] = Ordering.by(_.id)
  def empty: Data229 = Data229(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data229 =
    Data229(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data229] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
