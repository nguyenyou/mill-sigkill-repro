package generated

final case class Data1039(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1039 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1039 = copy(value = value * k)
  def addTag(t: String): Data1039 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1039 = copy(meta = meta.updated(k, v))
  def merge(other: Data1039): Data1039 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1039 {
  given Ordering[Data1039] = Ordering.by(_.id)
  def empty: Data1039 = Data1039(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1039 =
    Data1039(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1039] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
