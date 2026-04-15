package generated

final case class Data1410(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1410 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1410 = copy(value = value * k)
  def addTag(t: String): Data1410 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1410 = copy(meta = meta.updated(k, v))
  def merge(other: Data1410): Data1410 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1410 {
  given Ordering[Data1410] = Ordering.by(_.id)
  def empty: Data1410 = Data1410(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1410 =
    Data1410(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1410] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
