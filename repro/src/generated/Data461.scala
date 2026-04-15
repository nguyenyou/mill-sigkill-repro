package generated

final case class Data461(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data461 = copy(name = name.toUpperCase)
  def scale(k: Double): Data461 = copy(value = value * k)
  def addTag(t: String): Data461 = copy(tags = t :: tags)
  def put(k: String, v: String): Data461 = copy(meta = meta.updated(k, v))
  def merge(other: Data461): Data461 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data461 {
  given Ordering[Data461] = Ordering.by(_.id)
  def empty: Data461 = Data461(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data461 =
    Data461(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data461] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
