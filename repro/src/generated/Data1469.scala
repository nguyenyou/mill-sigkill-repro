package generated

final case class Data1469(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1469 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1469 = copy(value = value * k)
  def addTag(t: String): Data1469 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1469 = copy(meta = meta.updated(k, v))
  def merge(other: Data1469): Data1469 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1469 {
  given Ordering[Data1469] = Ordering.by(_.id)
  def empty: Data1469 = Data1469(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1469 =
    Data1469(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1469] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
