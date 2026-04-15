package generated

final case class Data1234(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1234 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1234 = copy(value = value * k)
  def addTag(t: String): Data1234 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1234 = copy(meta = meta.updated(k, v))
  def merge(other: Data1234): Data1234 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1234 {
  given Ordering[Data1234] = Ordering.by(_.id)
  def empty: Data1234 = Data1234(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1234 =
    Data1234(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1234] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
