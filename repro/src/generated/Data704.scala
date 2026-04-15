package generated

final case class Data704(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data704 = copy(name = name.toUpperCase)
  def scale(k: Double): Data704 = copy(value = value * k)
  def addTag(t: String): Data704 = copy(tags = t :: tags)
  def put(k: String, v: String): Data704 = copy(meta = meta.updated(k, v))
  def merge(other: Data704): Data704 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data704 {
  given Ordering[Data704] = Ordering.by(_.id)
  def empty: Data704 = Data704(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data704 =
    Data704(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data704] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
