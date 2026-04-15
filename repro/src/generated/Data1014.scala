package generated

final case class Data1014(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1014 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1014 = copy(value = value * k)
  def addTag(t: String): Data1014 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1014 = copy(meta = meta.updated(k, v))
  def merge(other: Data1014): Data1014 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1014 {
  given Ordering[Data1014] = Ordering.by(_.id)
  def empty: Data1014 = Data1014(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1014 =
    Data1014(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1014] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
