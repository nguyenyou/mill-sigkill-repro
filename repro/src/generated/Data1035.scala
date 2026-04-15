package generated

final case class Data1035(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1035 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1035 = copy(value = value * k)
  def addTag(t: String): Data1035 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1035 = copy(meta = meta.updated(k, v))
  def merge(other: Data1035): Data1035 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1035 {
  given Ordering[Data1035] = Ordering.by(_.id)
  def empty: Data1035 = Data1035(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1035 =
    Data1035(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1035] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
