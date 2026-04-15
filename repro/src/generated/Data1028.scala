package generated

final case class Data1028(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1028 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1028 = copy(value = value * k)
  def addTag(t: String): Data1028 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1028 = copy(meta = meta.updated(k, v))
  def merge(other: Data1028): Data1028 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1028 {
  given Ordering[Data1028] = Ordering.by(_.id)
  def empty: Data1028 = Data1028(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1028 =
    Data1028(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1028] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
