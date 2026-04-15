package generated

final case class Data1156(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1156 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1156 = copy(value = value * k)
  def addTag(t: String): Data1156 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1156 = copy(meta = meta.updated(k, v))
  def merge(other: Data1156): Data1156 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1156 {
  given Ordering[Data1156] = Ordering.by(_.id)
  def empty: Data1156 = Data1156(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1156 =
    Data1156(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1156] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
