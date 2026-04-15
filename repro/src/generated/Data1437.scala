package generated

final case class Data1437(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1437 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1437 = copy(value = value * k)
  def addTag(t: String): Data1437 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1437 = copy(meta = meta.updated(k, v))
  def merge(other: Data1437): Data1437 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1437 {
  given Ordering[Data1437] = Ordering.by(_.id)
  def empty: Data1437 = Data1437(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1437 =
    Data1437(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1437] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
