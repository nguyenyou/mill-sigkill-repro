package generated

final case class Data1472(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1472 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1472 = copy(value = value * k)
  def addTag(t: String): Data1472 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1472 = copy(meta = meta.updated(k, v))
  def merge(other: Data1472): Data1472 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1472 {
  given Ordering[Data1472] = Ordering.by(_.id)
  def empty: Data1472 = Data1472(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1472 =
    Data1472(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1472] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
