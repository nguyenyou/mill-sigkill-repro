package generated

final case class Data1448(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1448 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1448 = copy(value = value * k)
  def addTag(t: String): Data1448 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1448 = copy(meta = meta.updated(k, v))
  def merge(other: Data1448): Data1448 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1448 {
  given Ordering[Data1448] = Ordering.by(_.id)
  def empty: Data1448 = Data1448(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1448 =
    Data1448(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1448] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
